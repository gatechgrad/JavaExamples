//2020 - Levi D. Smith
//levidsmith.com


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TicTacToePanel extends JPanel implements ActionListener {

	TicTacToeBoard board;

	JButton buttonRestart;
	final String RESTART_LABEL = "Restart";

	public TicTacToePanel() {
		buttonRestart = new JButton(RESTART_LABEL);
		buttonRestart.addActionListener(this);
		this.add(buttonRestart);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		String strCommand = e.getActionCommand();
		
		if (strCommand.equals(RESTART_LABEL)) {
			board.restart();
		}
	}
	
	public void setBoard(TicTacToeBoard b) {
		board = b;
	}




}