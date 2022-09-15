package zombie.apocalypse.kata;

public class Survivor implements Character {

    private final String name;
    private int life;
    private int experience;
    private Item leftHand;
    private Item rightHand;
    private Bag bag;

    public Survivor(String name, int initialLife, int initialExperience) {
        this.name = name;
        this.life = initialLife;
    }

    public void takeItemWithLeftHand(Item item) {
        if(leftHand == null) this.leftHand = item;

        bag.saveItem(item);
    }

    public void takeItemWithRightHand(Item item) {
        if(rightHand == null) this.rightHand = item;

        bag.saveItem(item);
    }

    public boolean attack(){
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CharacterType type() {
        return CharacterType.SURVIVOR;
    }
}
