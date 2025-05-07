package j.dice;
import java.util.Scanner;

public class 使用遞迴結構計算費氏數列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans, input;
        while (sc.hasNext()){
            input = sc.nextInt();
            ans = f(input);
            System.out.println(ans);
        }
        sc.close();
    }

    public static int f(int input){
        if (input == 0){
            return 0;
        }
        else if (input == 1){
            return 1;
        }
        else{
            return (f((input - 1)) + f((input - 2)));
        }
    }
}
