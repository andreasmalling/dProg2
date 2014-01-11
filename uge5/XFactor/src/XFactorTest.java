public class XFactorTest {

	public static void main(String[] args) {
		// Check number of arguments
		if(args.length != 2) {
			System.err.println("Shut up, fool!");
			System.exit(1);
		}

		int arg1, arg2;
		// Check if arguments are valid types
		try {
			arg1 = Integer.parseInt(args[0]);
			arg2 = Integer.parseInt(args[1]);
			XFactor x = new XFactor();
			System.out.println(	"The A-team is convinced that "
						+ arg1 + "^" + arg2 + " is " + 
						x.getXFactor(arg1,arg2)		// Calculates arg1^arg2 with recursive methodcall
						+ "!!!"); 
		} catch (NumberFormatException e) {
			System.err.println( "I ain't goin' on no airplane!");
			System.exit(2);
    		}
	}
}
