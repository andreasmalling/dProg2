import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

public class GuardGUI{
	private Counter cars;
	private int parkingLots;
	
	/**
	 * GuardGUI controls the gate of a parkinghouse, and is able to signal others when
	 * a car arrives or leaves.
	 * 
	 * @param parkingLots The total number of parking lots in the parkinghouse.
	 */
	public GuardGUI(int parkingLots){
		this.parkingLots = parkingLots;
		cars = new Counter(this.parkingLots);
		
		drawGUI();
	}
	
	/**
	 * Notifies all assigned ChangeListeners of current number of free parking lots.
	 * Useful for initializing new ChangeListeners.
	 */
	private void refreshListeners(){
		cars.change(0);
	}
	
	/**
	 * Decrement number of free parking lots, because of car arriving.
	 * Notifies all assigned ChangeListeners.
	 * 
	 * @return	True: 	Car entered successfully
	 * 			False: 	Otherwise
	 */
	public boolean carEnters(){
		if(cars.getValue() > 0 ){
			cars.change(-1);
			return true;
		} else
			return false;
	}
	
	/**
	 * Increment number of free parking lots, because of car leaving.
	 * Notifies all assigned ChangeListeners.
	 * 
	 * @return	True: 	Car exited successfully
	 * 			False: 	Otherwise
	 */
	public boolean carExits(){
		if(cars.getValue() < parkingLots){
			cars.change(1);
			return true;
		} else
			return false;
	}
	
	/**
	 * Add ChangeListeners to be notified of changes in the number of cars parked
	 * and notifies them of current state.
	 * 
	 * @param l ChangeListener to be notified of changes.
	 */
	public void addListener(ChangeListener l){
		cars.addChangeListener(l);
		refreshListeners();
	}
	
	/**
	 * Draw two button GUI for guardGUI control.
	 */
	public void drawGUI(){
		/* Draw Frame */
		JFrame guardFrame = new JFrame("GuardGUI");
		guardFrame.setLayout(new FlowLayout());
		
		/* Draw Buttons */
		JPanel buttons = new JPanel();
		JButton enterButton = new JButton("Bil kører ind");
		JButton exitButton = new JButton("Bil kører ud");
		buttons.add(enterButton);
		buttons.add(exitButton);
		guardFrame.add(buttons);
		
		/* Assign ActionListeners to buttons */
		enterButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( !carEnters() ){
					JOptionPane.showMessageDialog(
				        null,
				        "There are no free parking lots left",
				        "No room left",
				        JOptionPane.WARNING_MESSAGE
				    );
				}
			}
		});
		
		exitButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( !carExits() ){
					JOptionPane.showMessageDialog(
				        null,
				        "All cars have left the parking lot",
				        "No cars left",
				        JOptionPane.WARNING_MESSAGE
				    );
				}
			}
		});
		
		guardFrame.pack();
		guardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guardFrame.setVisible(true);
	}
}