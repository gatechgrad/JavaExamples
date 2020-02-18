import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DrawingPrimitivesComponent extends JComponent {

	public DrawingPrimitivesComponent() {
		setPreferredSize(new Dimension(800, 600));
	
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(255, 0, 255));
		g.fillArc(200, 50, 100, 100, 0, 270);
		
		g.setColor(Color.cyan);
		g.fillOval(400, 50, 100, 100);
		
		g.setColor(Color.blue);
		g.fillRect(200, 200, 100, 100);
		
		g.setColor(new Color(255, 128, 0));
		g.drawRect(400, 200, 100, 100);
		
		g.setColor(Color.green);
		g.fillRoundRect(200, 400, 100, 100, 20, 20);
		
		g.setColor(Color.red);
		g.drawLine(400, 400, 500, 500);
		g.drawLine(500, 400, 400, 500);
		
		g.setColor(Color.white);
		g.drawString("fillArc", 220, 100);
		g.drawString("fillRect", 220, 250);

		g.setColor(Color.black);
		g.drawString("fillOval", 420, 100);
		g.drawString("drawRect", 420, 250);
		g.drawString("fillRoundRect", 220, 450);
		g.drawString("drawLine", 420, 450);
	}



}