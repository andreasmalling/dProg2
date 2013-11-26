import java.util.*;

public class MultiSetTest {
	public static void main(String[] args) {
		MultiSet<String> a = new MultiSet<String>();
		MultiSet<String> b = new MultiSet<String>();

		try {
			a.remove("test");
		} catch (NullPointerException ex) {
			assert false : "Fail remove test 1; Probably you are trying to call the get-method on your map, for a key value that is not present. Hint: use containsKey before using get.";
		}

		assert !a.remove("test") : "Fail remove test 2; only return true if the collection changed as a result of remove";

		a.add("Foo");
		a.add("Bar");
		a.add("Foo");
		System.out.println("a:" + a); // test toString

		b.add("Bar");
		b.add("Foo");
		b.add("Bar");
		b.add("Foo");
		System.out.println("b:" + b);
		assert a.size() == 3 : "Fail size test 1";
		assert b.size() == 4 : "Fail size test 2";

		assert !a.equals(b) : "Failed test 1!"; // test equals
		assert b.remove("Bar") : "Failed test 2!"; // test remove
		assert a.equals(b) : "Failed test 3!";
		for (String s : a) { // test iterator
			assert b.remove(s) : "Failed test 4!";
		}
		assert b.size() == 0 : "Failed test 5!";

		Set<String> baseSet = new HashSet<String>(a);
		assert baseSet.size() == 2 : "Failed test 6!";

		b = new MultiSet<String>(a);
		assert a.equals(b) : "Failed test 7!";

		try {
			assert false;
			System.out.println("Please enable assertions!");
		} catch (AssertionError e) {
			System.out.println("Success!");
		}
	}
}