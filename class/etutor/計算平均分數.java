import java.util.Scanner;

public class 計算平均分數 {
    public static void main(String[] args) {

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

        if (count > 0) {
            System.out.printf("%.1f\n", (double) sum / count);
        }

    }
}
