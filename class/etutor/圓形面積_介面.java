import java.util.Scanner;

interface Shape {
    double ComputeArea();
}

class CCircle implements Shape {
    final double PI = 3.14;
    double radius;

    public CCircle(double r) {
        radius = r;
    }

    public double ComputeArea() {
        return radius * radius * PI;
    }
}

public class 圓形面積_介面 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        CCircle c = new CCircle(r);
        System.out.printf("%.2f\n", c.ComputeArea());
        sc.close();
    }
}
