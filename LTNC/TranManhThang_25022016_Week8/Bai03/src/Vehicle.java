abstract class Vehicle {
    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    // Phương thức template để tránh lặp code nối chuỗi
    public String getInfo() {
        return getVehicleType() + " [" + plate + "] - " + brand;
    }

    // Buộc lớp con phải định nghĩa loại xe là gì
    protected abstract String getVehicleType();
}
