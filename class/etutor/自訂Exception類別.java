import java.util.Scanner;

class LocationMismatchException extends Exception {
    public LocationMismatchException(String message) {
        super(message);
    }
}

class GenderMismatchException extends Exception {
    public GenderMismatchException(String message) {
        super(message);
    }
}

class LengthErrorException extends Exception {
    public LengthErrorException(String message) {
        super(message);
    }
}

public class 自訂Exception類別 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String id = sc.nextLine();

                try {
                    validateID(id);
                    System.out.println("ID is valid");
                } catch (LocationMismatchException e) {
                    System.out.println("Invalid Location Character");
                } catch (GenderMismatchException | LengthErrorException e) {
                    System.out.println("Invalid Serial Number");
                }
            }
        }
    }

    public static void validateID(String id)
            throws LocationMismatchException, GenderMismatchException, LengthErrorException {
        if (id.length() != 10) {
            throw new LengthErrorException("身分證字號長度錯誤");
        }

        char location = id.charAt(0);
        if (!Character.isLetter(location)) {
            throw new LocationMismatchException("開頭不是英文字母");
        }

        char gender = id.charAt(1);
        if (gender != '1' && gender != '2') {
            throw new GenderMismatchException("性別碼錯誤");
        }
    }
}
