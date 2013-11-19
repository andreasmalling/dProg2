public class Truck extends Drivable {
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

    public void fill(int i) {
        fuel += i;
    }
}