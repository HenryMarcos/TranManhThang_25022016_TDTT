public class Car extends Vehicle {
    public Car(String plate, int type) {
        super(plate, type);
    }

    @Override
    public double calculateFee(int hours) {
        double fee = 10;
        if (hours > 2) fee += (hours - 2) * 3;
        return fee;
    }
}
