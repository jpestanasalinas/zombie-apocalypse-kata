package zombie.apocalypse.kata;

public class Scenario {

    private Cell[][] cells;

    public Scenario(int size) {
        this.cells = new Cell[size][size];
    }

    private boolean hasZombie() {
        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                if (cell1.hasZombie()) return true;
            }
        }
        return false;
    }
}
