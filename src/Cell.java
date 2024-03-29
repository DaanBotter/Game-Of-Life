public class Cell {

    private boolean isAlive;
    private Location location;

    public Cell(boolean isAlive, Location location) {
        this.isAlive = isAlive;
        this.location = location;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Location getLocation() {
        return location;
    }

    public void die() {
        this.isAlive = false;
    }

    public void live() {
        this.isAlive = true;
    }
}
