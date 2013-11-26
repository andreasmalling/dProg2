public class MultiSetTest {
	public static void main(String[] args) {
		MultiSet zoo = new MultiSet();

		// Create Zoo
		zoo.add("Abe");
		zoo.add("Kat");
		zoo.add("Due");
		zoo.add("Kat");
		zoo.add("Kat");
		System.out.println(zoo);

		// Curiosity killed the Cat
		zoo.remove("Kat");
		System.out.println(zoo);
	}
}
