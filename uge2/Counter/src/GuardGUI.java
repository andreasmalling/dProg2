import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuardGUI{
	private Counter cars;
	
	/**
	 * GuardGUI controls the gate of a parkinghouse, and is able to signal others when
	 * a car arrives or leaves.
	 * 
	 * @param parkingLots The total number of parking lots in the parkinghouse.
	 */
	public GuardGUI(Counter cars){
		this.cars = cars;
		
		drawGUI();
	}
	
	/**
	 * Decrement number of free parking lots, because of car arriving.
	 * Notifies all assigned ChangeListeners.
	 * 
	 * @return	True: 	Car entered successfully
	 * 			False: 	Otherwise
	 */
	public void carEnters(){
		cars.change(-1);
	}
	
	/**
	 * Increment number of free parking lots, because of car leaving.
	 * Notifies all assigned ChangeListeners.
	 * 
	 * @return	True: 	Car exited successfully
	 * 			False: 	Otherwise
	 */
	public void carExits(){
		cars.change(1);
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
				carEnters();
			}
		});
		
		exitButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carExits();
			}
		});
		
		guardFrame.pack();
		guardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guardFrame.setVisible(true);
	}
}