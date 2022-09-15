package zombie.apocalypse.kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .collect(Collectors.toList());

        this.survivors = survivors.stream()
                .filter(it -> !it.getName().equals(characterName))
                .collect(Collectors.toList());
    }
}
