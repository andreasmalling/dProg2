public class ParkingTest{
	public static void main(String[] args){
		GuardGUI bruunsGalleri = new GuardGUI(5);
		bruunsGalleri.addListener( new RoadGUI("East Sign") );
		bruunsGalleri.addListener( new RoadGUI("West Sign") );
	}
}