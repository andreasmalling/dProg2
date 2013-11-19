public class ParkingTest{
	public static void main(String[] args){
		Counter bruunsGalleri = new Counter(5);
		GuardGUI westEntrance = new GuardGUI(bruunsGalleri);
		GuardGUI eastEntrance = new GuardGUI(bruunsGalleri);
		bruunsGalleri.addChangeListener( new RoadGUI("East Sign") );
		bruunsGalleri.addChangeListener( new RoadGUI("West Sign") );
	}
}