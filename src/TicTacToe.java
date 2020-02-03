//2020 - Levi D. Smith
//levidsmith.com

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class TicTacToe {
	
	TicTacToeBoard board;
	TicTacToePanel panelButtons;

	public TicTacToe() {
		JFrame f = new JFrame("TicTacToe");
		
		board = new TicTacToeBoard();
		panelButtons = new TicTacToePanel();
		panelButtons.setBoard(board);
		
		
		f.getContentPane().add(board, BorderLayout.CENTER);
		f.getContentPane().add(panelButtons, BorderLayout.SOUTH);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	
	}
	
	public static void main(String args[]) {
		new TicTacToe();
	}
}