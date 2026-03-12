public class CentralHub {
    public void registerDevice(SmartLight light) {
        System.out.printf("[HUB] is connecting to device: %s\n", light.getName());
    }
}
