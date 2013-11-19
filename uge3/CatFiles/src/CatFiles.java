import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class CatFiles {

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Du skal indtaste minimum én input-fil og én output-fil");
			System.exit(1);
		}
		try {
			FileWriter writer = 
					new FileWriter(args[args.length-1]);
			System.out.println("Filen \"" + args[args.length-1] + "\" blev åbnet");
			for(int i = 0; i < args.length-1; i++){	
				try {
					Scanner in = 
							new Scanner(new FileReader(args[i]));
					while(in.hasNext())
						writer.write( in.next() );
					in.close();
					System.out.println("Filen \"" + args[i] + "\" blev kopieret");
				} catch(FileNotFoundException e) {
					System.out.println("Filen \"" + args[i] + "\" findes ikke");
				}
			}
			writer.close();	
		} catch(Exception e) {
			System.out.println("Output-fil fejl");
		}
	}
}
