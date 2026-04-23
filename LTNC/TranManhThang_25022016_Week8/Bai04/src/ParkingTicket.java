class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }
    public Vehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }

     public double getFee() {
        return vehicle.calculateFee(hours);
    }

    public int getBonus() {
        return vehicle.calculateBonus(hours);
    }

    public String getPlate() {
        return vehicle.getPlate();
    }
}
