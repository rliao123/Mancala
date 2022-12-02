import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Stone {

	private int x;
	private int y;
	private int count;

	public Stone(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void draw(Graphics2D g2) {
		
		int tempX = x;
		int tempY = y;
		
		Ellipse2D.Double dot = new Ellipse2D.Double(tempX, tempY, 5, 5);;
		
		g2.setColor(Color.black);
		g2.fill(dot);
		g2.draw(dot);
		
	}
}