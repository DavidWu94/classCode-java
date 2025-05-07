import java.util.Scanner;

public class 物件相加多載 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine(); // 讀取一整行輸入
        sc.close();

        String[] tokens = line.split(" "); // 依空白切割

        // 呼叫 add 方法
        add(tokens);
    }

    public static void add(String[] inputs) {
        boolean allInt = true;
        boolean allDouble = true;

        for (String s : inputs) {
            if (!s.matches("-?\\d+")) { // 非整數
                allInt = false;
            }
            if (!s.matches("-?\\d+(\\.\\d+)?")) { // 非浮點數
                allDouble = false;
            }
        }

        if (allInt) {
            int sum = 0;
            for (String s : inputs) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        } else if (allDouble) {
            double sum = 0;
            for (String s : inputs) {
                if (!s.matches("-?\\d+")) { // 非整數才相加
                    double round = Math.round(Double.parseDouble(s) * 10) / 10.0;
                    sum += round;
                }
            }
            double ans = Double.valueOf(String.format("%.1f", sum));
            System.out.println(ans);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : inputs) {
                sb.append(s);
            }
            System.out.println(sb);
        }

    }
}
