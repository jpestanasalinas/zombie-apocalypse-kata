package zombie.apocalypse.kata;

public class Scenario {

    private Cell[][] cells;
    private int size;

    public Scenario(int size) {
        this.cells = new Cell[size][size];
        this.size = size;
    }

    private boolean hasZombie() {
        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                if (cell1.hasZombie()) return true;
            }
        }
        return false;
    }

    public void makeAMove(String characterName, Direction direction) {
        for (int x = 0; x <= cells.length; x++) {
            for (int y = 0; y <= cells.length; y++) {
                if (cells[x][y].contains(characterName))
                    moveTo(x, y, direction, characterName);

            }
        }
    }

    private void moveTo(int x, int y, Direction direction, String characterName) {
        switch (direction) {
            case EAST:
                cells[x+1][y].add(cells[x][y].getCharacter(characterName));
                cells[x][y].remove(characterName);
                break;
            case WEST:
                cells[x-1][y].add(cells[x][y].getCharacter(characterName));
                cells[x][y].remove(characterName);
                break;
            case NORTH:
                cells[x][y+1].add(cells[x][y].getCharacter(characterName));
                cells[x][y].remove(characterName);
                break;
            case SOUTH:
                cells[x][y-1].add(cells[x][y].getCharacter(characterName));
                cells[x][y].remove(characterName);
                break;
        }
    }


}
