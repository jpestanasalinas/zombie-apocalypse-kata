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
        Coordinates coordinates = findCharacter(characterName);
        moveTo(coordinates.x, coordinates.y, direction, characterName);
    }

    public void collectItem(String characterName, String itemType, Hand hand) {
        Coordinates coordinates = findCharacter(characterName);
        cells[coordinates.x][coordinates.y].collectItem(characterName,itemType, hand);
    }

    private Coordinates findCharacter(String characterName) {
        for (int x = 0; x <= cells.length; x++) {
            for (int y = 0; y <= cells.length; y++) {
                if (cells[x][y].contains(characterName))
                    return new Coordinates(x,y);
            }
        }
        return null;
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
