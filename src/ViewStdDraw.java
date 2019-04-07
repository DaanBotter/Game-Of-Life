import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class ViewStdDraw implements View {

    private int width;
    private int height;
    private ArrayList<Color> colors = new ArrayList<>();

    public ViewStdDraw(int width, int height) {
        if (width < 1) {
            throw new IllegalArgumentException("width must be a positive value");
        }
        if (height < 1) {
            throw new IllegalArgumentException("height must be a positive value");
        }
        this.width = width;
        this.height = height;
        this.colors.add(Color.RED);
        this.colors.add(Color.GREEN);
        this.colors.add(Color.BLUE);

        // Set de canvas size 35x de grootte van de cells.
        StdDraw.setCanvasSize(width * 35, height * 35);
        StdDraw.setYscale(0, height * 35);
        StdDraw.setXscale(0, width * 35);
    }

    @Override
    public void drawGeneration(List<Cell> generation) {
        StdDraw.show();
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();

        for (Cell cell : generation) {
            if (cell.isAlive()) {
                // Random kleuren
                Random random = new Random();
                int colorInt = random.nextInt(3);
                StdDraw.setPenColor(this.colors.get(colorInt));

                // + 15 omdat de square 15 px groot is ten opzichte van het midden.
                StdDraw.filledSquare((cell.getLocation().getCol() * 35) + 15, (cell.getLocation().getRow() * 35) + 15, 15);
            }
        }

        StdDraw.show();
    }

}