import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CatFiles {

	public static void main(String[] args) {
		if(args.length < 3) {
			System.out.println("Du skal indtaste minimum to input-filer og én output-fil");
			System.exit(1);
		}
		try {
			FileWriter writer = 
					new FileWriter(args[args.length-1]);
			System.out.println("Filen \"" + args[args.length-1] + "\" blev åbnet");
			for(int i = 0; i < args.length-1; i++){	
				try {
					Scanner in = 
							new Scanner(new FileInputStream(args[i]));
					while(in.hasNextLine())
						writer.write( in.nextLine() + "\n" );
					in.close();
					System.out.println("Filen \"" + args[i] + "\" blev kopieret");
				} catch(FileNotFoundException e) {
					System.out.println("Filen \"" + args[i] + "\" findes ikke");
				}
			}
			writer.close();	
		} catch(IOException e) {
			System.out.println("Output-fil fejl");
		}
	}
}