package zombie.apocalypse.kata;

public class Map {

    private Cell[][] coordinates;

    public Map(int size) {
        this.coordinates = new Cell[size][size];
    }
}
