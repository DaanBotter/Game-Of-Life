public class GameOfLife {

    private GameOfLife(int height, int width) {
        if (width < 1) {
            throw new IllegalArgumentException("width must be positive");
        }
        if (height < 1) {
            throw new IllegalArgumentException("height must be positive");
        }
        Simulator simulator = new Simulator(height, width);
        simulator.populate();
    }

    public static void main(String[] args) {
        new GameOfLife(12, 12);
    }

}
