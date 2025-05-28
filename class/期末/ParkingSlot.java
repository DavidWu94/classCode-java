public class ParkingSlot {
    public String carNumber;
    public String date; // YYYYMMDD
    public String time; // HHMM
    public String slotId; // 4碼

    public ParkingSlot(String carNumber, String date, String time, String slotId) {
        this.carNumber = carNumber;
        this.date = date;
        this.time = time;
        this.slotId = slotId;
    }
}