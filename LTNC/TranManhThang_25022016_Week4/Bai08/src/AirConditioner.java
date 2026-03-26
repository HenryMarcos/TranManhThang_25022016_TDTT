public class AirConditioner extends Electronic implements Wifi {
    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void setupWifi() {
        System.out.println(name + " connected to wifi");
    }
    
}