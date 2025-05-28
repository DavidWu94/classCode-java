import java.util.Scanner;

public class Main {
    static ParkingTower tower;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入預設檔案名稱(如PreloadExample.txt): ");
        System.out.println("目前工作目錄: " + System.getProperty("user.dir"));
        String preloadFile = sc.next();
        tower = new ParkingTower(preloadFile);

        while (true) {
            System.out.println("請輸入執行動作(parking/unparking/dump/exit):");
            String order = sc.next();
            if (order.equals("parking")) {
                System.out.println("請輸入車牌號碼:");
                String carNumber = sc.next();
                System.out.println(tower.parking(carNumber));
            } else if (order.equals("unparking")) {
                System.out.println("請輸入車牌號碼或車位編號:");
                String carNumber = sc.next();
                System.out.println(tower.unparking(carNumber));
            } else if (order.equals("dump")) {
                System.out.println("請輸入樓層(查詢全部樓層:all):");
                String floor = sc.next();
                System.out.print(tower.dump(floor));
            } else if (order.equals("exit")) {
                System.out.println("程式結束");
                break;
            } else {
                System.out.println("無效的指令");
            }
        }
        sc.close();
        System.out.println("謝謝使用停車塔系統");
    }
}