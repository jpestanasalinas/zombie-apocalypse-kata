package zombie.apocalypse.kata;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Cell {

    public List<Character> survivors;
    public List<Item> items;
    public List<Character> zombies;

    public Cell(List<Character> survivors, List<Item> items, List<Character> zombies) {
        this.survivors = survivors;
        this.items = items;
        this.zombies = zombies;
    }

    public boolean hasZombie(){
        return zombies.size() == 0;
    }

    public boolean contains(String characterName) {
        return Stream.concat(survivors.stream(), zombies.stream()).anyMatch(it -> it.getName().equals(characterName));
    }

    public Character getCharacter(String characterName) {
        return Stream.concat(survivors.stream(), zombies.stream())
                .filter(it -> it.getName().equals(characterName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
    }

    public void add(Character character) {
        if(character.type() == CharacterType.ZOMBIE) zombies.add(character);
        else survivors.add(character);
    }

    public void remove(String characterName) {
        this.zombies = zombies.stream()
                .filter(it -> !it.getName().equals(characterName))
                .collect(toList());

        this.survivors = survivors.stream()
                .filter(it -> !it.getName().equals(characterName))
                .collect(toList());
    }

    public void collectItem(String characterName, String itemType, Hand hand) {
        survivors.stream()
                .filter(it -> it.getName().equals(characterName))
                .findFirst().ifPresent(it -> take((Survivor) it, itemType, hand));
        items = items.stream()
                .filter(it -> !it.getType().equals(itemType))
                .collect(toList());
    }

    private void take(Survivor character, String itemType, Hand hand) {
            findItem(itemType).ifPresent(it -> takeWithHand(character, hand, it));
    }

    private void takeWithHand(Survivor character, Hand hand, Item find) {
        if (Hand.LEFT.equals(hand)) character.takeItemWithLeftHand(find);
        else character.takeItemWithRightHand(find);
    }

    public Optional<Item> findItem(String itemType) {
        return items.stream().filter(it -> it.getType().equals(itemType)).findFirst();
    }
}
