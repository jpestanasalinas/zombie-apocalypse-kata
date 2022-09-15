package zombie.apocalypse.kata;

public class Zombie implements Character {

    public String name;

    public boolean bite(){
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public CharacterType type() {
        return CharacterType.ZOMBIE;
    }
}
