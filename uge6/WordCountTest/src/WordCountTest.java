public class WordCountTest {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Du skal indtaste minimum en input-fil");
			System.exit(1);
		}

		Runnable r;
		Thread t;
		for(int i = 0; i < args.length; i++){
			r = new WordCount(args[i]);
			t = new Thread(r);
			t.start();
		}
	}
}