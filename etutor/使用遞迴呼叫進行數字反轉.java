package j.etutor;

import java.util.Scanner;

public class 使用遞迴呼叫進行數字反轉 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println(reverseNumber(n));
    }

    public static int reverseNumber(int n) {
        return reverseHelper(n, 0);
    }

    private static int reverseHelper(int n, int reversed) {
        if (n == 0) {
            return reversed;
        }
        return reverseHelper(n / 10, reversed * 10 + n % 10);
    }
}
