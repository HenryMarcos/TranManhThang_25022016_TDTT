import java.util.ArrayList;

public class Hub {
    ArrayList<Electronic> electronics;

    public Hub() {
        electronics = new ArrayList<>();
    }

    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");
        for (int i = 0; i < electronics.size(); i++) {
            electronics.get(i).turnOff();
        }
    }

    public void setupWifi() {
        System.out.println("Setup Wifi:");
        for (int i = 0; i < electronics.size(); i++) {
            if (electronics.get(i) instanceof Wifi) {
                ((Wifi) electronics.get(i)).setupWifi();
            }
        }
    }

    public void add(Electronic e) {
        electronics.add(e);
    }
}
