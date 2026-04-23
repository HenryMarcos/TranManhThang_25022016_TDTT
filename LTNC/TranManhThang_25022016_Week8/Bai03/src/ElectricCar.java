class ElectricCar extends ElectricVehicle {

    public ElectricCar(String plate, String brand, int batteryPercent) { 
        super(plate, brand, batteryPercent); 
    }

    public ElectricCar(String plate, String brand) { super(plate, brand); }

    @Override
    protected String getVehicleType() { return "Xe điện"; }
}
