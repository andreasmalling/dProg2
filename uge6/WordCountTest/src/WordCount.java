import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount implements Runnable {
	private static int id = 0;
	private int myId;
	private String file;


	public WordCount(String file) {
		this.file = file;
		myId = ++id;
	}

	@Override
	public void run() {
		System.out.println("Thread " + myId + " running");
		System.out.println(file + ": " + countWords(file));
	}

	public int countWords(String file) {
		int count = 0;
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			while(in.hasNext()) {
				count++;
				in.next();
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("Filen \"" + file + "\" findes ikke");
		}
		return count;
	}
}
