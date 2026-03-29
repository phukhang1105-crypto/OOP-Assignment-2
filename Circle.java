public class Circle extends Shape {
    private double radius;

    public Circle(Coordinates coord, double radius) {
        super(0, coord);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);


        if (sign) {
            radius *= factor;
        } else {
            radius /= factor;
        }
    }

    @Override
    public String display() {
        return "Circle [" + position.display() +
                ", Radius=" + radius +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter() + "]";
    }
}