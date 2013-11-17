import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RoadGUI implements ChangeListener{
	private int freeSpaces;
	private String id;
	private JFrame roadFrame;
	private JLabel roadMessage = new JLabel("No info");
	
	/**
	 * RoadGUI can show the number of free parking lots, when notified.
	 * @param id Name of the RoadGUI
	 */
	public RoadGUI(String id){
		this.id = id;
		
		drawGUI();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() instanceof Counter){		// Check for type, before casting
			Counter l = (Counter) e.getSource();	// Cast ChangeEvent to Counter
			freeSpaces = l.getValue();				// Get new number of parking lots
			updateGUI();
		}
	}
	
	private void drawGUI() {
		roadFrame = new JFrame("RoadGUI: " + id);
		roadFrame.add(roadMessage);
		roadFrame.pack();
		roadFrame.setVisible(true);
	}
	
	private void updateGUI() {
		roadMessage.setText(freeSpaces + " ledige P-pladser");
		roadFrame.pack();
		roadFrame.repaint();
	}
}