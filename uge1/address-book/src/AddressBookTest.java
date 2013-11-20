
public class AddressBookTest {
	public static void main(String[] args) {
		if( args[0].equals("-t")) {
			AddressBookDemoText myGUI = new AddressBookDemoText();
			myGUI.showInterface();
		} else {
			AddressBookDemoGUI myGUI = new AddressBookDemoGUI();
			myGUI.showInterface();
		}
	}
}
