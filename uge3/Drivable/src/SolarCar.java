public class SolarCar implements Drivable {
    private double mileage = 0.0;
    
    public boolean drive(int distance) {
        mileage += distance;
        return true;
    }
    
    public double getMileage() {
        return mileage;
    }
}