public class Truck implements Drivable {
    private double mileage = 0.0;
    private double fuel = 0.0;
    private double kmPrLiter = 5.0;
    
    public boolean drive(int distance) {
        double fuelUsage = distance/kmPrLiter;
        if (fuelUsage <= fuel) {
            fuel -= fuelUsage;
            mileage += distance;
            return true;
        }        
        else return false;
    }
    
    public double getMileage() {
        return mileage;
    }
    
    public void fill(int i) {
        fuel += i;
    }
}