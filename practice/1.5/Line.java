public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);;
    }

    public int length(){
        return (int) Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }

    public String toString() {
        return String.format("Линия от %s до %s", start, end);
    }


}