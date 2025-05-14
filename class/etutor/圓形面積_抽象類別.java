import java.util.Scanner;

abstract class Shape {
    final double PI = 3.14;

    abstract double ComputeArea();
}

class CCircle extends Shape {
    double radius;
    public CCircle(double r) {
        radius = r;
    }

    double ComputeArea(){
        return radius * radius * PI;
    }
}

public class 圓形面積_抽象類別 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        CCircle c = new CCircle(r);
        System.out.printf("%.2f\n", c.ComputeArea());
        sc.close();
    }
}
