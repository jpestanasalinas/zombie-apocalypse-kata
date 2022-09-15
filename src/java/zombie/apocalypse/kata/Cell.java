package zombie.apocalypse.kata;

import java.util.List;

public class Cell {

    public List<Survivor> survivors;
    public List<Item> items;
    public List<Zombie> zombies;

    public Cell(List<Survivor> survivors, List<Item> items, List<Zombie> zombies) {
        this.survivors = survivors;
        this.items = items;
        this.zombies = zombies;
    }

    public boolean hasZombie(){
        return zombies.size() == 0;
    }
}
