import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<HotelRoom> hotel = new ArrayList<>();

        while (sc.hasNext()) {
            String caseNumber = sc.nextLine();
            String roomType = sc.next();
            int stayingDays = sc.nextInt();
            HotelRoom room = new HotelRoom(caseNumber, roomType, stayingDays);
            hotel.add(room);

            sc.nextLine();
        }

        for (HotelRoom room : hotel) {
            System.out.println(room);
        }
    }
}
