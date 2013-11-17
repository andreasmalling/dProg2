import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconGUI {
	private CompositeIcon icons = new CompositeIcon();
	private JFrame gui = new JFrame("Icon GUI");
	
	public IconGUI() {
		gui.setLayout( new FlowLayout() );
		
		/* Create and add buttons to Frame */
		JPanel buttons = new JPanel();
		JButton redButton = new JButton("Red");
		JButton blueButton = new JButton("Blue");
		JButton yellowButton = new JButton("Yellow");
		buttons.add( redButton );
		buttons.add( blueButton );
		buttons.add( yellowButton );
		
		gui.add(buttons);
		
		/* Create and add CompositeIcon to Frame*/
		gui.add( new JLabel(icons) );
		
		/* Create actionListeners for buttons using the method makeListener() */
		redButton.addActionListener( makeListener(new SquareIcon(20, Color.RED)) );
		blueButton.addActionListener( makeListener(new SquareIcon(30, Color.BLUE)) );
		yellowButton.addActionListener( makeListener(new SquareIcon(40, Color.YELLOW)) );
		
		gui.pack();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
	
	/**
	 * Creates anonymous actionListener class that adds icon to CompositeIcon
	 * and updates the GUI using pack() and repaint()
	 * 
	 * @param ic Icon that is added to the CompositeIcon that is painted in the GUI
	 * @return anonymous actionListener adding icon and updating the GUI
	 */
	private ActionListener makeListener(final Icon ic) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icons.addIcon(ic);
				gui.pack();
				gui.repaint();
			}
		};
	}
}