import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> listOfShapes;

    public ShapeList() {
        listOfShapes = new ArrayList<>();
    }


    public void addShape(Shape s) {
        listOfShapes.add(s);
    }


    public Shape getShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.get(pos);
        } else {
            System.out.println("Invalid position!");
            return null;
        }
    }


    public Shape removeShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.remove(pos);
        } else {
            System.out.println("Invalid position!");
            return null;
        }
    }


    public void translateShapes(int dx, int dy) {
        for (Shape s : listOfShapes) {
            s.translate(dx, dy);
        }
    }


    public void scale(int factor, boolean sign) {
        for (Shape s : listOfShapes) {
            s.scale(factor, sign);
        }
    }


    public int getNumberOfShapes() {
        return listOfShapes.size();
    }


    public double area(int pos) {
        Shape s = getShape(pos);
        if (s != null) {
            return s.getArea();
        }
        return 0;
    }


    public double perimeter(int pos) {
        Shape s = getShape(pos);
        if (s != null) {
            return s.getPerimeter();
        }
        return 0;
    }

    public String display() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < listOfShapes.size(); i++) {
            result.append("Shape ").append(i).append(": ")
                    .append(listOfShapes.get(i).display())
                    .append("\n");
        }

        return result.toString();
    }
}
