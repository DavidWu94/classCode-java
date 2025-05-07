import java.util.Scanner;

public class 計算平均分數使用method呼叫 {
    public static void main(String[] args) {
        double result = average();
        System.out.printf("%.1f\n", result);
    }

    public static double average() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, count = 0;

        while (true) {
            int num = scanner.nextInt();
            if (num == -1)
                break;
            if (num >= 0 && num <= 100) {
                sum += num;
                count++;
            }
        }

        scanner.close();
        return count > 0 ? (double) sum / count : 0.0;
    }
}
