public abstract class ElectricVehicle extends Vehicle {
    protected int batteryPercent;  // Chỉ xe điện mới dùng

    public ElectricVehicle(String plate, String brand, int batteryPercent) {
        super(plate, brand);
        this.batteryPercent = batteryPercent;
    }
    public ElectricVehicle(String plate, String brand) {
        this(plate, brand, 0);
    }

    public void charge(int percent) { batteryPercent += percent; }
}
