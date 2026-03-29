public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(Coordinates coord, double width, double length) {
        super(4, coord);
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void scale(int factor, boolean sign) {

        position.scale(factor, sign);

        if (sign) {
            width *= factor;
            length *= factor;
        } else {
            width /= factor;
            length /= factor;
        }
    }

    @Override
    public String display() {
        return "Rectangle [" + position.display() +
                ", Width=" + width +
                ", Length=" + length +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter() + "]";
    }
}