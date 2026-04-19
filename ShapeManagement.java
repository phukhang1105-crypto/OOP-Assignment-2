import java.util.Scanner;
import java.util.InputMismatchException;

public class ShapeManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeList shapeList = new ShapeList();

        int choice = -1;

        do {
            System.out.println("\n===== SHAPE MANAGEMENT MENU =====");
            System.out.println("1: Add a shape");
            System.out.println("2: Remove a shape by position");
            System.out.println("3: Get information about a shape by position");
            System.out.println("4: Area and perimeter of a shape by position");
            System.out.println("5: Display all shapes");
            System.out.println("6: Translate all shapes");
            System.out.println("7: Scale all shapes");
            System.out.println("0: Quit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        addShape(sc, shapeList);
                        break;

                    case 2:
                        System.out.print("Enter position to remove: ");
                        int posRemove = sc.nextInt();
                        Shape removed = shapeList.removeShape(posRemove);
                        if (removed != null) {
                            System.out.println("Shape removed.");
                        }
                        break;

                    case 3:
                        System.out.println(shapeList.display());
                        System.out.print("Enter position: ");
                        int posInfo = sc.nextInt();
                        Shape s = shapeList.getShape(posInfo);
                        if (s != null) {
                            System.out.println(s.display());
                        }
                        break;

                    case 4:
                        System.out.println(shapeList.display());
                        System.out.print("Enter position: ");
                        int posCalc = sc.nextInt();
                        Shape shape = shapeList.getShape(posCalc);
                        if (shape != null) {
                            System.out.println("Area: " + shape.getArea());
                            System.out.println("Perimeter: " + shape.getPerimeter());
                        }
                        break;

                    case 5:
                        System.out.println(shapeList.display());
                        break;

                    case 6:
                        System.out.print("Enter dx: ");
                        int dx = sc.nextInt();
                        System.out.print("Enter dy: ");
                        int dy = sc.nextInt();
                        shapeList.translateShapes(dx, dy);
                        System.out.println("All shapes translated.");
                        break;

                    case 7:
                        System.out.print("Enter factor: ");
                        int factor = sc.nextInt();
                        System.out.print("Enter true to multiply, false to divide: ");
                        boolean sign = sc.nextBoolean();
                        shapeList.scale(factor, sign);
                        System.out.println("All shapes scaled.");
                        break;

                    case 0:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter the correct data type.");
                sc.nextLine();
            }

        } while (choice != 0);

        sc.close();
    }

    private static void addShape(Scanner sc, ShapeList shapeList) {
        try {
            System.out.println("\nChoose shape:");
            System.out.println("1: Rectangle");
            System.out.println("2: Circle");
            System.out.println("3: Triangle");
            System.out.println("4: Square");
            System.out.print("Enter choice: ");

            int type = sc.nextInt();

            switch (type) {

                case 1:
                    System.out.print("Enter x and y: ");
                    int rx = sc.nextInt();
                    int ry = sc.nextInt();
                    System.out.print("Enter width and length: ");
                    double width = sc.nextDouble();
                    double length = sc.nextDouble();

                    shapeList.addShape(new Rectangle(new Coordinates(rx, ry), width, length));
                    System.out.println("Rectangle added.");
                    break;

                case 2:
                    if (shapeList.getNumberOfShapes() == 0) {
                        System.out.println("No shapes available to remove.");
                        break;
                    }

                    System.out.println(shapeList.display());
                    System.out.print("Enter position to remove: ");
                    int posRemove = sc.nextInt();

                    if (posRemove < 0 || posRemove >= shapeList.getNumberOfShapes()) {
                        System.out.println("Error: Position does not exist.");
                    } else {
                        Shape removed = shapeList.removeShape(posRemove);
                        System.out.println("Shape removed successfully.");
                    }
                    break;

                case 3:
                    if (shapeList.getNumberOfShapes() == 0) {
                        System.out.println("No shapes in the list.");
                        break;
                    }

                    System.out.println(shapeList.display());
                    System.out.print("Enter position: ");
                    int posInfo = sc.nextInt();

                    if (posInfo < 0 || posInfo >= shapeList.getNumberOfShapes()) {
                        System.out.println("Error: Invalid position.");
                    } else {
                        Shape s = shapeList.getShape(posInfo);
                        System.out.println(s.display());
                    }
                    break;

                case 4:
                    if (shapeList.getNumberOfShapes() == 0) {
                        System.out.println("No shapes in the list.");
                        break;
                    }

                    System.out.println(shapeList.display());
                    System.out.print("Enter position: ");
                    int posCalc = sc.nextInt();

                    if (posCalc < 0 || posCalc >= shapeList.getNumberOfShapes()) {
                        System.out.println("Error: Cannot calculate. Position does not exist.");
                    } else {
                        Shape shape = shapeList.getShape(posCalc);
                        System.out.println("Area: " + shape.getArea());
                        System.out.println("Perimeter: " + shape.getPerimeter());
                    }
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct values.");
            sc.nextLine();
        }
    }

}