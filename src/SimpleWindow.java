//2020 - Levi D. Smith
//levidsmith.com
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SimpleWindow {
	
	public SimpleWindow() {
		JFrame f = new JFrame("Simple Window");
		JLabel label = new JLabel("Hello World");
		label.setPreferredSize(new Dimension(800, 600));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sans Serif", Font.PLAIN, 96));
		f.getContentPane().add(label);
		f.pack();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String args[]) {
		new SimpleWindow();
	}
	
}