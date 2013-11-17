import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Can print squares of supplied numbers, through CLI 
 */
public class Square {
	/**
	 * Print squares of numbers supplied through the terminal by
	 * the user. The quantity of numbers is given through the 
	 * commandline, as a parameter.
	 *  
	 * @param args Quantity of numbers to square
	 */
	public static void main(String[] args) {
		/* Validate input */
		try {
			int n = Integer.parseInt(args[0]);	// Inputstring to integer
		
			/* Create array of given input size */
			int[] nArray = new int[n];
			
			/* Fill array */
			Scanner in = new Scanner(System.in);
			for(int i=0 ; i<n ; i++) {
		        System.out.printf("indtast tal nummer " + (i+1) + ": ");
		        nArray[i]=in.nextInt();
			}
			in.close();
			
			/* Output squares of input */
			System.out.printf( "kvadraterne på de indtastede tal er:");
			for(int i=0 ; i<n ; i++) {
				System.out.printf( " " + (int) Math.pow(nArray[i], 2));
			}
		} catch(Exception e) {
			System.out.println("du skal indtaste et gyldigt tal");
			System.exit(1);
		}
	}
}
