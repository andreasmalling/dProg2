import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinomialApplet extends Applet {
	private final int FIELD_WIDTH = 3;

	private int n, k;
	private TextField inputN = new TextField(FIELD_WIDTH);
	private TextField inputK = new TextField(FIELD_WIDTH);
	private JButton calculateButton = new JButton("Calculate");
	private JButton modeButton = new JButton("Mode: B1");
	private JLabel result = new JLabel("Result:");
	private Binomial method = new Binomial1();

	public void init() {
		/* Setup GUI */
		setLayout(new FlowLayout());
		add(modeButton);
		add(new JLabel("n:"));
		add(inputN);
		add(new JLabel("k:"));
		add(inputK);
		add(calculateButton);
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
				callBinomial();
			}
		});
	}

	private void callBinomial() {
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

		/* Calculate */
		result.setText( "Result: " + method.binomial(n,k) );
	}
}