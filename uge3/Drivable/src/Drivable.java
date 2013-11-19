public abstract class Drivable {
	protected double mileage;
	
	public Drivable(){
		mileage = 0.0;
	}
	
    public abstract boolean drive(int distance);
    
    public double getMileage() {
        return mileage;
    }
}