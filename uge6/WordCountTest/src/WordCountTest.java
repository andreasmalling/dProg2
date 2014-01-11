import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WordCountTest {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Du skal indtaste minimum en input-fil");
			System.exit(1);
		}
		BlockingQueue<Integer> threadQueue = new LinkedBlockingQueue<Integer>();

		Runnable r;
		Thread t;
		for(int i = 0; i < args.length; i++){
			r = new WordCount(args[i], threadQueue);
			t = new Thread(r);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {}
		}
		int total = 0;
		for(Integer i: threadQueue)
			total += i;
		System.out.println("Total words: " + total);
	}
}