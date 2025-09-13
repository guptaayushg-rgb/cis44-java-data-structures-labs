import java.util.Scanner;

interface Polygon {
    double area();
    double perimeter();
}

class Quadrilateral implements Polygon {
    protected double a, b, c, d;

    public Quadrilateral(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double area() {
        return 0;
    }

    public double perimeter() {
        return a + b + c + d;
    }
}

class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

class Pentagon implements Polygon {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    public double perimeter() {
        return 5 * side;
    }

    public double area() {
        return (5 * side * side) / (4 * Math.tan(Math.PI / 5));
    }
}

class Hexagon implements Polygon {
    private double side;

    public Hexagon(double side) {
        this.side = side;
    }

    public double perimeter() {
        return 6 * side;
    }

    public double area() {
        return (3 * Math.sqrt(3) / 2) * side * side;
    }
}

class Octagon implements Polygon {
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    public double perimeter() {
        return 8 * side;
    }

    public double area() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }
}

class Triangle implements Polygon {
    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double s = perimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, side, side);
    }

    public double area() {
        return (Math.sqrt(3) / 4) * a * a;
    }
}

public class PolygonMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polygon polygon = null;

        System.out.println("Create a polygon:");
        System.out.println("1. Triangle");
        System.out.println("2. Isosceles Triangle");
        System.out.println("3. Equilateral Triangle");
        System.out.println("4. Rectangle");
        System.out.println("5. Square");
        System.out.println("6. Pentagon");
        System.out.println("7. Hexagon");
        System.out.println("8. Octagon");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter 3 sides: ");
                polygon = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                break;
            case 2:
                System.out.print("Enter equal side and base: ");
                polygon = new IsoscelesTriangle(scanner.nextDouble(), scanner.nextDouble());
                break;
            case 3:
                System.out.print("Enter side: ");
                polygon = new EquilateralTriangle(scanner.nextDouble());
                break;
            case 4:
                System.out.print("Enter length and width: ");
                polygon = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
                break;
            case 5:
                System.out.print("Enter side: ");
                polygon = new Square(scanner.nextDouble());
                break;
            case 6:
                System.out.print("Enter side: ");
                polygon = new Pentagon(scanner.nextDouble());
                break;
            case 7:
                System.out.print("Enter side: ");
                polygon = new Hexagon(scanner.nextDouble());
                break;
            case 8:
                System.out.print("Enter side: ");
                polygon = new Octagon(scanner.nextDouble());
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        System.out.println("Perimeter: " + polygon.perimeter());
        System.out.println("Area: " + polygon.area());
        scanner.close();
    }
}

