import java.util.Scanner;

interface Common {
    double area();

    double perimeter();

    String getShapeType();
}

abstract class Shape implements Common {
    private String shapeType;

    Shape(String type) {
        shapeType = type;
    }

    public String getShapeType() {
        return shapeType;
    }
}

class Circle extends Shape { // 圓形
    private double radius;

    Circle(String type, double radius) {
        super(type);
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square extends Shape { // 正方形
    private double side;

    Square(String type, double side) {
        super(type);
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }
}

class Rectangle extends Shape { // 長方形
    private double length, width;

    Rectangle(String type, double length, double width) {
        super(type);
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

class IsoscelesTriangle extends Shape { // 等腰三角形
    private double base, height;

    IsoscelesTriangle(String type, double base, double height) {
        super(type);
        this.base = base;
        this.height = height;
    }

    public double area() {
        return (base * height) / 2;
    }

    public double perimeter() {
        double side = Math.sqrt(Math.pow(base / 2, 2) + Math.pow(height, 2));
        return base + 2 * side;
    }
}

public class 繼承與介面應用 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String shape = sc.nextLine();

        Shape s = null;

        switch (shape.toUpperCase()) {
            case "CIRCLE":
                double r = sc.nextDouble();
                s = new Circle(shape, r);
                break;
            case "SQUARE":
                double side = sc.nextDouble();
                s = new Square(shape, side);
                break;
            case "RECTANGLE":
                double len = sc.nextDouble();
                double wid = sc.nextDouble();
                s = new Rectangle(shape, len, wid);
                break;
            case "ISOSCELES TRIANGLE":
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                s = new IsoscelesTriangle(shape, base, height);
                break;
            default:
                System.out.println("Wrong shape type!");
                sc.close();
                return;
        }

        sc.close();
        System.out.println("Shape type=" + s.getShapeType().toUpperCase());
        System.out.printf("Area=%.1f\n", s.area());
        System.out.printf("Perimeter=%.1f\n", s.perimeter());

    }
}
