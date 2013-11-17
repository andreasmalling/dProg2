import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.Icon;

public class CompositeIcon implements Icon{
	private ArrayList<Icon> icons = new ArrayList<Icon>();
	
	public void paintIcon(Component c, Graphics g, int x, int y){
		int tempX = x;
		for( Icon i: icons){
			i.paintIcon(c, g, tempX, y);
			tempX += i.getIconWidth();
		}
	}
    
	public int getIconWidth(){
		int totalWidth = 0;
		for( Icon i: icons){
			totalWidth += i.getIconWidth();
		}
		return totalWidth;
	}

    public int getIconHeight(){
    	int maxHeight = 0;
		for( Icon i: icons){
			if( maxHeight < i.getIconHeight() )
				maxHeight = i.getIconHeight();
		}
		return maxHeight;
    }
    
    public void addIcon(Icon ic){
    	icons.add(ic);
    }
}