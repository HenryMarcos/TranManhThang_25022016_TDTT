public class Main {
    public static void main(String[] args) {
        // Tạo danh sách các phương tiện
        Vehicle[] vehicles = {
            new MotorBike("29A-12345", "Honda"),
            new Car("30H-99999", "Toyota"),
            new ElectricCar("51G-88888", "VinFast")
        };

        // Kiểm tra output
        for (Vehicle v : vehicles) {
            System.out.println(v.getInfo());
        }
    }
}