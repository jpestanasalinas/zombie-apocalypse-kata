package zombie.apocalypse.kata;

import java.util.List;

public class Bag {

    private List<Item> items;

    public boolean saveItem(Item item) {
        if (items.size() == 3) return false;

        items.add(item);
        return true;
    }
}
