import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DrawingPrimitives {
	
	public DrawingPrimitives() {
		JFrame f = new JFrame("Simple Window");
		
		DrawingPrimitivesComponent dpc = new DrawingPrimitivesComponent();
		
		f.getContentPane().add(dpc);
		f.pack();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String args[]) {
		new DrawingPrimitives();
	}
	
}