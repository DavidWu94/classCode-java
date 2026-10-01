import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int initialAmount = 1000;
        int expenses01 = sc.nextInt();
        int expenses02 = sc.nextInt();
        int expenses03 = sc.nextInt();
        int expenses04 = sc.nextInt();
        int expenses05 = sc.nextInt();

        System.out.printf("%+05d%n", initialAmount);

        int totalExpense = 0;
        System.out.printf("%+05d%n", -expenses01);
        totalExpense += expenses01;
        System.out.printf("%+05d%n", -expenses02);
        totalExpense += expenses02;
        System.out.printf("%+05d%n", -expenses03);
        totalExpense += expenses03;
        System.out.printf("%+05d%n", -expenses04);
        totalExpense += expenses04;
        System.out.printf("%+05d%n", -expenses05);
        totalExpense += expenses05;


        System.out.println("-----");

        int balance = initialAmount - totalExpense;
        System.out.printf("%+05d%n", balance);

    }
}