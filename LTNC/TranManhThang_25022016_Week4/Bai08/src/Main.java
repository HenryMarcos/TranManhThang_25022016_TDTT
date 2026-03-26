import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int electronicAmount = sc.nextInt();

        Hub hub = new Hub();
        
        for (int i = 0; i < electronicAmount; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            switch (type) {
                case "L":
                    hub.add(new SmartLight(id, name));
                    break;
                case "AC":
                    hub.add(new AirConditioner(id, name));
                    break;
                case "S":
                    hub.add(new SmartSpeaker(id, name));
                    break;
                case "C":
                    hub.add(new AutomaticCurtain(id, name));
                    break;
                default:
                    break;
            }
            sc.nextLine();
        }
        hub.turnOffAll();
        System.out.println();
        hub.setupWifi();
    }
}
