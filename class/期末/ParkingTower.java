import java.io.*;
import java.time.*;
import java.time.format.*;

public class ParkingTower {
    public ParkingSlot[][] slots = new ParkingSlot[10][25];

    public ParkingTower(String preloadFile) {
        preload(preloadFile);
    }

    // 載入預設資料
    private void preload(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename.trim()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.trim().split("\\s+");
                if (arr.length < 4)
                    continue;
                String carNumber = arr[0];
                String date = arr[1];
                String time = arr[2];
                String slotId = arr[3];
                int floor = Integer.parseInt(slotId.substring(0, 2)) - 1;
                int idx = Integer.parseInt(slotId.substring(2, 4)) - 1;
                if (floor >= 0 && floor < 10 && idx >= 0 && idx < 25) {
                    slots[floor][idx] = new ParkingSlot(carNumber, date, time, slotId);
                }
            }
        } catch (IOException e) {
            System.out.println("預設檔案讀取失敗: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("預設檔案格式錯誤: " + e.getMessage());
        }
    }

    // 停車
    public String parking(String carNumber) {
        carNumber = carNumber.trim();
        // 檢查是否已停車
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 25; j++)
                if (slots[i][j] != null && slots[i][j].carNumber.equals(carNumber))
                    return "此車已停放於 " + slots[i][j].slotId;

        // 找第一個空位
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 25; j++) {
                if (slots[i][j] == null) {
                    String slotId = String.format("%02d%02d", i + 1, j + 1);
                    LocalDateTime now = LocalDateTime.now();
                    String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                    String time = now.format(DateTimeFormatter.ofPattern("HHmm"));
                    slots[i][j] = new ParkingSlot(carNumber, date, time, slotId);
                    return "停車成功，車位編號: " + slotId + " 時間: " + date + " " + time;
                }
            }
        }
        return "停車塔已滿";
    }

    // 領車
    public String unparking(String input) {
        input = input.trim();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 25; j++)
                if (slots[i][j] != null && (slots[i][j].carNumber.equals(input) || slots[i][j].slotId.equals(input))) {
                    // 計算停車費
                    ParkingSlot slot = slots[i][j];
                    LocalDateTime inTime = LocalDateTime.parse(slot.date + slot.time,
                            DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
                    LocalDateTime outTime = LocalDateTime.now();
                    long minutes = Duration.between(inTime, outTime).toMinutes();
                    long hours = (minutes + 59) / 60; // 不足一小時以一小時計

                    // 計算費用
                    int total = 0;
                    LocalDateTime t = inTime;
                    for (int h = 0; h < hours; h++) {
                        int hour = t.getHour();
                        if (hour >= 8 && hour < 20)
                            total += 30;
                        else
                            total += 20;
                        t = t.plusHours(1);
                    }

                    String result = String.format("車牌:%s 車位:%s\n停車時間:%d小時\n停車費:%d元", slot.carNumber, slot.slotId, hours,
                            total);
                    slots[i][j] = null;
                    return result;
                }
        return "查無此車或車位";
    }

    // 傾印
    public String dump(String floor) {
        floor = floor.trim().toLowerCase();
        StringBuilder sb = new StringBuilder();
        if (floor.equals("all")) {
            for (int i = 0; i < 10; i++) {
                sb.append("樓層 ").append(i + 1).append(":\n");
                for (int j = 0; j < 25; j++) {
                    if (slots[i][j] != null)
                        sb.append(String.format("  %s %s %s %s\n", slots[i][j].slotId, slots[i][j].carNumber,
                                slots[i][j].date, slots[i][j].time));
                }
            }
        } else {
            try {
                int f = Integer.parseInt(floor) - 1;
                if (f < 0 || f >= 10)
                    return "樓層輸入錯誤";
                sb.append("樓層 ").append(f + 1).append(":\n");
                for (int j = 0; j < 25; j++) {
                    if (slots[f][j] != null)
                        sb.append(String.format("  %s %s %s %s\n", slots[f][j].slotId, slots[f][j].carNumber,
                                slots[f][j].date, slots[f][j].time));
                }
            } catch (NumberFormatException e) {
                return "樓層輸入錯誤";
            }
        }
        return sb.toString();
    }
}