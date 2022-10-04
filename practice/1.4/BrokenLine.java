import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine {

    private List<Point> points;

    public BrokenLine() {
        this(new ArrayList<>());
    }

    public BrokenLine(Point ...points) {
        this(Arrays.asList(points));
    }

    public BrokenLine(List<Point> points) {
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
