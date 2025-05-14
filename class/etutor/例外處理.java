import java.util.Scanner;

public class 例外處理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String st1 = sc.next();

            if (st1.equalsIgnoreCase("Quit")) {
                break;
            }

            String st2 = sc.next();

            try {
                int v1 = Integer.parseInt(st1);
                int v2 = Integer.parseInt(st2);

                if (v2 == 0) {
                    throw new ArithmeticException();
                }

                System.out.println(v1 / v2);
            } catch (NumberFormatException e1) {
                System.out.println("Invalid input!");
                break;
            } catch (ArithmeticException e2) {
                System.out.println("Divide by zero!");
                break;
            }
        }

        System.out.println("Program terminated.");
        sc.close();
    }
}
