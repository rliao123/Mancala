import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class StonesIcon implements Icon{
	
	private int width;
	private int height;
	private Stone s;
	
	public StonesIcon(Stone s, int width, int height) {
		this.s = s;
		this.width = width;
		this.height = height;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		s.draw(g2);
		
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}

}
