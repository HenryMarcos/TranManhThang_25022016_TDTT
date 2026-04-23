public abstract class GasVehicle extends Vehicle {
    protected double fuelLevel;    // Chỉ xe chạy xăng mới dùng

    public GasVehicle(String plate, String brand, double fuelLevel) {
        super(plate, brand);
        this.fuelLevel = fuelLevel;
    }

    public GasVehicle(String plate, String brand) {
        this(plate, brand, 0);
    }

    public void refuel(double liters) { fuelLevel += liters; }
}
