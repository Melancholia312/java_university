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

    public int length(){

        if (points.size() < 2){
            return 0;
        }

        int finalLength = 0;
        Point prevPoint = points.get(0);

        for (int i = 1; i < points.size(); i ++){
            finalLength += new Line(prevPoint, points.get(i)).length();
        }

        return finalLength;
    }

    public void addPoint(Point ... points){
        this.points.addAll(Arrays.asList(points));
    }

    public void addPoint(ArrayList<Point> points){
        this.points.addAll(points);
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public void setPoint(int index, Point point) {
        points.set(index, point);
    }

    public int getSize(){
        return points.size();
    }

    public String toString() {
        return String.format("Линия: %s", points);
    }


}
