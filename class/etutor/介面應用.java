import java.util.Scanner;

interface Common {
    double PI = 3.14;

    double area();

    double perimeter();
}

class Shape {
    private int shapeType;

    Shape(int t) {
        shapeType = t;
    }

    double getShapeType() {
        return shapeType;
    }

    void setShapeType(int t) {
        shapeType = t;
    }
}

// 等腰三角形
class Triangle extends Shape implements Common {
    private double base;
    private double height;

    Triangle(int t, double b, double h) {
        super(t);
        base = b;
        height = h;
    }

    double getBase() {
        return base;
    }

    double getHeight() {
        return height;
    }

    void setBase(double b) {
        base = b;
    }

    void setHeight(double h) {
        height = h;
    }

    public double area() {
        return (base * height) / 2;
    }

    public double perimeter() {
        double side = Math.sqrt(Math.pow(base / 2, 2) + Math.pow(height, 2));
        return base + 2 * side;
    }
}

// 長方形
class Rectangle extends Shape implements Common {
    private double width;
    private double height;

    Rectangle(int t, double w, double h) {
        super(t);
        width = w;
        height = h;
    }

    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    void setWidth(double w) {
        width = w;
    }

    void setHeight(double h) {
        height = h;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }
}

// 圓形
class Circle extends Shape implements Common {
    private double radius;

    Circle(int t, double r) {
        super(t);
        radius = r;
    }

    double getRadius() {
        return radius;
    }

    void setRadius(double r) {
        radius = r;
    }

    public double area() {
        return PI * radius * radius;
    }

    public double perimeter() {
        return 2 * PI * radius;
    }
}

public class 介面應用 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int k = sc.nextInt();
            System.out.printf("%d ", k);
            switch (k) {
                case 1: // 圓形
                    double radius = sc.nextDouble();
                    Circle c = new Circle(k, radius);
                    System.out.printf("%.1f %.1f%n", c.area(), c.perimeter());
                    break;
                case 2: // 長方形
                    double width = sc.nextDouble();
                    double height = sc.nextDouble();
                    Rectangle r = new Rectangle(k, width, height);
                    System.out.printf("%.1f %.1f%n", r.area(), r.perimeter());
                    break;
                case 3: // 等腰三角形
                    double base = sc.nextDouble();
                    double h = sc.nextDouble();
                    Triangle t = new Triangle(k, base, h);
                    System.out.printf("%.1f %.1f%n", t.area(), t.perimeter());
                    break;
                default:
                    System.out.println("Wrong shape type");
                    break;
            }
        }
        sc.close();
    }
}
