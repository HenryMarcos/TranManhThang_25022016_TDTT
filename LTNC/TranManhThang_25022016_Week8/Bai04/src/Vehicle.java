abstract class Vehicle {
    static final int CAR = 0;
    static final int BIKE = 1;
    static final int TRUCK = 2;

    private final String plate;
    private final int type;

    public Vehicle(String plate, int type) {
        this.plate = plate;
        this.type = type;
    }
    public String getPlate() { return plate; }
    public int getType() { return type; }

    public abstract double calculateFee(int hours);

    public int calculateBonus(int hours) {
        return 1; // Mặc định mỗi vé được 1 điểm
    }
}
