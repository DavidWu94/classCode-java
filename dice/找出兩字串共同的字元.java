package j.dice;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

public class 找出兩字串共同的字元 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input1 = sc.next();
            String input2 = sc.next();
            String ans = findChar(input1, input2);
            System.out.println(ans != null ? ans : "null");  // 確保輸出為 "null"
        }

        sc.close();
    }

    public static String findChar(String st1, String st2) {
        Set<Character> set1 = new TreeSet<>();
        Set<Character> ansset = new TreeSet<>();

        for (char c : st1.toCharArray()) {
            set1.add(c);
        }

        for (char c : st2.toCharArray()) {
            if (set1.contains(c)) {
                ansset.add(c);
            }
        }

        if (ansset.isEmpty()) {
            return null;  // 如果沒有共同字元，回傳 null
        }

        // 使用 StringBuilder 將共同字元組合成字串
        StringBuilder ans = new StringBuilder();
        for (char c : ansset) {
            ans.append(c);
        }

        return ans.toString();
    }
}
