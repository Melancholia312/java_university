public class Point {
    private int x, y;

    public Point(Point point){
        this(point.getX(), point.getY());
    }
    public Point(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String toString() {
        return String.format("{%d;%d}", x, y);
    }

}