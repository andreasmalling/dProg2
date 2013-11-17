import java.awt.*;
import javax.swing.*;

public class SquareIconTest {
    public static void main(String[] args) {
    	iconTest();
    	compositeIconTest();
    	compositeIconGUITest();
    }
    
    public static void compositeIconGUITest(){
    	@SuppressWarnings("unused")
		IconGUI myGUI = new IconGUI();
    }
    
    public static void compositeIconTest(){
    	SquareIcon red = new SquareIcon(20,Color.RED); 
        SquareIcon yellow = new SquareIcon(40,Color.YELLOW); 
        SquareIcon magenta = new SquareIcon(80,Color.MAGENTA); 
        SquareIcon blue = new SquareIcon(40,Color.BLUE); 
        
        CompositeIcon ci = new CompositeIcon();
        ci.addIcon(red);
        ci.addIcon(yellow);
        ci.addIcon(magenta);
        ci.addIcon(yellow);
        ci.addIcon(red);

        CompositeIcon ci2 = new CompositeIcon();
        ci2.addIcon(blue);
        ci2.addIcon(ci);
        ci2.addIcon(ci);
        ci2.addIcon(ci);
        ci2.addIcon(blue);

        JOptionPane.showMessageDialog(
            null,
            "CompositeIcon!",
            "CompositeIcon Test",
            JOptionPane.INFORMATION_MESSAGE,
            ci2
        );
    }
    
    public static void iconTest(){
	    SquareIcon icon = new SquareIcon(50,Color.BLUE);
	    JOptionPane.showMessageDialog(
	        null,
	        "Blue SquareIcon!",
	        "SquareIcon Test",
	        JOptionPane.INFORMATION_MESSAGE,
	        icon
	    );
    }
}