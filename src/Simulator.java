import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {
    private int height;
    private int width;
    private List<Cell> cells;

    public Simulator(int height, int width) {
        this.height = height;
        this.width = width;

        this.cells = new ArrayList<>();
    }

    public void runSimulation() {
        for (Cell cell : cells) {
            if (cell.isAlive()) {
                checkNeighbours(cell);
            }
        }
    }

    public void populate() {
        Random random = new Random();

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                boolean isAlive = random.nextBoolean();
                Location location = new Location(row, col);
                Cell cell = new Cell(isAlive, location);
                cells.add(cell);
            }
        }
        runSimulation();
    }

    private int checkNeighbours(Cell cell) {
        int col = cell.getLocation().getCol();
        int row = cell.getLocation().getRow();
        int numNeighbours = 0;
        try {
            // Zoek Noord
            numNeighbours = findCellByLocation(col, row - 1) ? numNeighbours + 1 : numNeighbours;

            // Zoek Noord-Oost
            numNeighbours = findCellByLocation(col + 1, row - 1) ? numNeighbours + 1 : numNeighbours;

            // Zoek Oost
            numNeighbours = findCellByLocation(col + 1, row) ? numNeighbours + 1 : numNeighbours;

            // Zoek Zuid-Oost
            numNeighbours = findCellByLocation(col + 1, row + 1) ? numNeighbours + 1 : numNeighbours;

            // Zoek Zuid
            numNeighbours = findCellByLocation(col, row + 1) ? numNeighbours + 1 : numNeighbours;

            // Zoek Zuid-West
            numNeighbours = findCellByLocation(col - 1, row + 1) ? numNeighbours + 1 : numNeighbours;

            // Zoek West
            numNeighbours = findCellByLocation(col - 1, row) ? numNeighbours + 1 : numNeighbours;

            // Zoek Noord-West
            numNeighbours = findCellByLocation(col - 1, row - 1) ? numNeighbours + 1 : numNeighbours;
        } catch (CellNotFoundException e) {
            e.printStackTrace();
        }

        return numNeighbours;
    }

    private boolean findCellByLocation(int col, int row) throws CellNotFoundException {
        if (row >= 0 && col >= 0 && row < this.height && col < this.width) {
            for (Cell cell : cells) {
                if (cell.getLocation().getRow() == row && cell.getLocation().getCol() == col) {
                    return cell.isAlive();
                }
            }
            throw new CellNotFoundException("Unable to find cell");
        } else {
            return false;
        }
    }
}