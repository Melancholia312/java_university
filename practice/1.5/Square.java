public class Square {

    private Point startPoint;
    private int sideLength;

    public Square(int x, int y, int sideLength){
        this(new Point(x,y), sideLength);
    }

    public Square(Point startPoint, int sideLength){
        this.sideLength = sideLength;
        this.startPoint = startPoint;
    }

    public BrokenLine returnBrokenLine(){
        return new BrokenLine(startPoint,
                new Point(startPoint.getX() + sideLength, startPoint.getY()),
                new Point(startPoint.getX() + sideLength, startPoint.getY() - sideLength),
                new Point(startPoint.getX() - sideLength, startPoint.getY() - sideLength));
    }

    public String toString() {
        return String.format("Квадрат в точке %s со стороной %d", startPoint, sideLength);
    }
}
