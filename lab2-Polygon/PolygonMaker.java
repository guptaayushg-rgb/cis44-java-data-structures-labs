import java.util.Scanner;

interface Shape {
    double getArea();
    double getPerimeter();
}

abstract class PolygonBase implements Shape {
    protected double[] sides;

    PolygonBase(double... sides) {
        this.sides = sides;
    }

    public double getPerimeter() {
        double sum = 0;
        for (double side : sides) sum += side;
        return sum;
    }
}

class GenTriangle extends PolygonBase {
    GenTriangle(double a, double b, double c) { super(a, b, c); }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
    }
}

class IsoTriangle extends GenTriangle {
    IsoTriangle(double equal, double base) { super(equal, equal, base); }
}

class EquiTriangle extends GenTriangle {
    EquiTriangle(double side) { super(side, side, side); }
}

class GenQuadrilateral extends PolygonBase {
    GenQuadrilateral(double a, double b, double c, double d) { super(a, b, c, d); }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt((s - sides[0]) * (s - sides[1]) * (s - sides[2]) * (s - sides[3]));
    }
}

class Rect extends GenQuadrilateral {
    private double length, width;

    Rect(double l, double w) {
        super(l, w, l, w);
        this.length = l; this.width = w;
    }

    public double getArea() {
        return length * width;
    }
}

class Sq extends Rect {
    Sq(double side) { super(side, side); }
}

class PentagonShape extends PolygonBase {
    PentagonShape(double... s) { super(s); }

    public double getArea() {
        double semi = getPerimeter() / 2;
        return Math.sqrt((semi - sides[0]) * (semi - sides[1]) * (semi - sides[2]) * (semi - sides[3]) * (semi - sides[4]));
    }
}

class HexagonShape extends PolygonBase {
    HexagonShape(double... s) { super(s); }

    public double getArea() {
        double semi = getPerimeter() / 2;
        double val = 1;
        for (double side : sides) val *= (semi - side);
        return Math.sqrt(val);
    }
}

class OctagonShape extends PolygonBase {
    OctagonShape(double... s) { super(s); }

    public double getArea() {
        double semi = getPerimeter() / 2;
        double val = 1;
        for (double side : sides) val *= (semi - side);
        return Math.sqrt(val);
    }
}

public class PolygonMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose a polygon:");
            System.out.println("1. Triangle");
            System.out.println("2. Isosceles Triangle");
            System.out.println("3. Equilateral Triangle");
            System.out.println("4. Quadrilateral");
            System.out.println("5. Rectangle");
            System.out.println("6. Square");
            System.out.println("7. Pentagon");
            System.out.println("8. Hexagon");
            System.out.println("9. Octagon");
            System.out.print("Enter choice: ");
            int ch = in.nextInt();

            Shape shape = null;

            switch (ch) {
                case 1 -> {
                    System.out.print("Side 1: "); double a = in.nextDouble();
                    System.out.print("Side 2: "); double b = in.nextDouble();
                    System.out.print("Side 3: "); double c = in.nextDouble();
                    shape = new GenTriangle(a, b, c);
                }
                case 2 -> {
                    System.out.print("Equal side: "); double e = in.nextDouble();
                    System.out.print("Base: "); double base = in.nextDouble();
                    shape = new IsoTriangle(e, base);
                }
                case 3 -> {
                    System.out.print("Side: "); double s = in.nextDouble();
                    shape = new EquiTriangle(s);
                }
                case 4 -> {
                    double[] sides = new double[4];
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Side " + (i + 1) + ": ");
                        sides[i] = in.nextDouble();
                    }
                    shape = new GenQuadrilateral(sides[0], sides[1], sides[2], sides[3]);
                }
                case 5 -> {
                    System.out.print("Length: "); double l = in.nextDouble();
                    System.out.print("Width: "); double w = in.nextDouble();
                    shape = new Rect(l, w);
                }
                case 6 -> {
                    System.out.print("Side: "); double side = in.nextDouble();
                    shape = new Sq(side);
                }
                case 7 -> {
                    double[] sides = new double[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Side " + (i + 1) + ": ");
                        sides[i] = in.nextDouble();
                    }
                    shape = new PentagonShape(sides);
                }
                case 8 -> {
                    double[] sides = new double[6];
                    for (int i = 0; i < 6; i++) {
                        System.out.print("Side " + (i + 1) + ": ");
                        sides[i] = in.nextDouble();
                    }
                    shape = new HexagonShape(sides);
                }
                case 9 -> {
                    double[] sides = new double[8];
                    for (int i = 0; i < 8; i++) {
                        System.out.print("Side " + (i + 1) + ": ");
                        sides[i] = in.nextDouble();
                    }
                    shape = new OctagonShape(sides);
                }
                default -> System.out.println("Invalid choice!");
            }

            if (shape != null) {
                System.out.println("Area = " + shape.getArea());
                System.out.println("Perimeter = " + shape.getPerimeter());
            }
        }
    }
}

