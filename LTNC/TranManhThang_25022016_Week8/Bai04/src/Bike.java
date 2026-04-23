public class Bike extends Vehicle {
    public Bike(String plate, int type) {
        super(plate, type);
    }

    @Override
    public double calculateFee(int hours) {
        double fee = 5;
        if (hours > 3) fee += (hours - 3) * 2;
        return fee;
    }
}
