public class Truck extends Vehicle {
    public Truck(String plate, int type) {
        super(plate, type);
    }

    @Override
    public double calculateFee(int hours) {
        return 15 + hours * 4;
    }
    @Override
    public int calculateBonus(int hours) {
        return (hours > 5) ? 2 : 1;
    }
}
