import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Simulator {
    private int height;
    private int width;
    private List<Cell> cells;

    public Simulator(int height, int width)
    {
        this.height = height;
        this.width = width;

        this.cells = new ArrayList<>();
    }

    public void runSimulation()
    {
        for(Iterator<Cell> cellIterator = cells.iterator(); cellIterator.hasNext();) {
            Cell cell  = cellIterator.next();
            cell.getLocation();
        }
    }

    public void populate()
    {
        Random random = new Random();

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                if(random.nextBoolean()) {
                    Location  location = new Location(row, col);
                    Cell cell = new Cell(true, location);
                    cells.add(cell);
                }
            }
        }

        runSimulation();
    }


}
