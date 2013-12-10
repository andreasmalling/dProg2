import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class WordCount implements Runnable {
	private static int id = 0;
	private int myId;
	private String file;
	private BlockingQueue<Integer> queue;


	public WordCount(String file, BlockingQueue<Integer> queue) {
		this.file = file;
		myId = ++id;
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("Thread " + myId + " running");
		try {
			queue.put( countWords(file) );
		} catch (InterruptedException e) {}
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
