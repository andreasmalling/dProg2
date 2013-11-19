public class SolarCar extends Drivable {
    public boolean drive(int distance) {
        mileage += distance;
        return true;
    }
}