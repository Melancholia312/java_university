import java.util.ArrayList;
import java.util.Arrays;

public class BrokenLine {

    private ArrayList<Point> points;

    public BrokenLine() {
        this(new ArrayList<>());
    }

    public BrokenLine(Point ...points) {
        this(new ArrayList<>(Arrays.asList(points)));
    }

    public BrokenLine(ArrayList<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public void setPoint(int index, Point point) {
        this.points.set(index, point);
    }

    public String toString() {
        return String.format("Линия: %s", points);
    }

}
