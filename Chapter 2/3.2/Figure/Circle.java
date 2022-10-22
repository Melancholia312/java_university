package Figure;

public class Circle extends Figure {

    private int radius;

    public Circle(Point startPoint, int radius){
        super(startPoint);
        if (radius < 0) throw new IllegalArgumentException();
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius < 0) throw new IllegalArgumentException();
        this.radius = radius;
    }

    @Override
    public int area() {
        return (int) (Math.PI * radius * radius);
    }
}
