import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadedBinomialApplet extends JApplet {
	private final int FIELD_WIDTH = 3;

	private TextField inputN = new TextField(FIELD_WIDTH);
	private TextField inputK = new TextField(FIELD_WIDTH);
	private JButton calculateButton = new JButton("Calculate");
	private JButton modeButton = new JButton("Mode: B1");
	private final JLabel result = new JLabel("--");
	private Binomial method = new Binomial1();
	private Thread methodThread = null;

	public void init() {
		/* Setup GUI */
		setLayout(new GridLayout(0,2));

		add(new JLabel("n:"));
		add(inputN);
		add(new JLabel("k:"));
		add(inputK);
		add(modeButton);
		add(calculateButton);
		add(new JLabel("Result:"));
		add(result);

		/* Select method for calculating */
		modeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if( modeButton.getText().equals("Mode: B1") ) {
					method = new Binomial2();
					modeButton.setText("Mode: B2");
				} else {
					method = new Binomial1();
					modeButton.setText("Mode: B1");
				}
			}
		});

		/* Calculate */
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				callBinomial(method);
			}
		});
	}

	private void callBinomial(final Binomial b) {
		final int n, k;

		/* Validate integer input */
		try {
			n = Integer.parseInt( inputN.getText() );
			k = Integer.parseInt( inputK.getText() );
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,
					"Values must be a number",
					"Value error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		/* Validate n and k value-size */
		if( k > n) {
			JOptionPane.showMessageDialog(null,
					"N-value must be greater than K-value",
					"Value error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if( n > 60) {
			JOptionPane.showMessageDialog(null,
					"Values must be less than 60",
					"Value error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if( n < 0 || k < 0) {
			JOptionPane.showMessageDialog(null,
					"Values must be greater or equal to 0",
					"Value error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		/* Kill previous thread */
		if(methodThread != null)
			methodThread.interrupt();

		/* Spawn new thread */
		methodThread = new Thread( new Runnable() {
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted())
					result.setText( String.valueOf(b.binomial(n, k)) );
			}
		});
		methodThread.start();
	}
}