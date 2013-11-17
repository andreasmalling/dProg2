import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class SquareIcon implements Icon{
	private int size;
	private Color color;
	
	public SquareIcon(int size, Color color) {
		this.size = size;
		this.color = color;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y){
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double square = new Rectangle2D.Double( x, y, size, size );
		g2.setColor(color);
		g2.fill(square);
	}
	
    public int getIconWidth(){
    	return size;
    }
    
    public int getIconHeight(){
    	return size;
    }
}