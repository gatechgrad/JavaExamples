//2020 - Levi D. Smith
//levidsmith.com

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TicTacToeBoard extends JComponent implements MouseListener {
	
	final int CELL_SIZE = 128;
	final int BOARD_ROWS = 3;
	final int BOARD_COLS = 3;
	int[][] iBoard;
	Font theFont;
	String[] strPlayers;
	
	int iCurrentPlayer;
	boolean keepPlaying;
	
	public TicTacToeBoard() {
		setPreferredSize(new Dimension(BOARD_COLS * CELL_SIZE, BOARD_ROWS * CELL_SIZE));
		
		iBoard = new int[BOARD_ROWS][BOARD_COLS];
		strPlayers = new String[2];
		strPlayers[0] = "X";
		strPlayers[1] = "O";
		
		theFont = new Font("Arial", Font.BOLD, 128);
		addMouseListener(this);
		
//		keepPlaying = true;
//		iCurrentPlayer = 1;
		restart();
	}
	
	

	public void paintComponent(Graphics g) {
		int i, j;
		
		g.setFont(theFont);
		FontMetrics fm = g.getFontMetrics(theFont);
		g.setColor(Color.white);
		g.fillRect(0, 0, BOARD_COLS * CELL_SIZE, BOARD_ROWS * CELL_SIZE);
		
		g.setColor(Color.black);
		for (i = 0; i < BOARD_COLS; i++) {
			g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, BOARD_ROWS * CELL_SIZE);
			
		}

		for (i = 0; i < BOARD_ROWS; i++) {
			g.drawLine(0, i * CELL_SIZE, BOARD_COLS * CELL_SIZE, i * CELL_SIZE);
			
		}
		
		for (i = 0; i < BOARD_ROWS; i++) {
			for (j = 0; j < BOARD_COLS; j++) {
				String strText = "";
				if (iBoard[i][j] == 1) {
					g.setColor(Color.red);
					strText = strPlayers[0];
				} else if (iBoard[i][j] == 2) {
					g.setColor(Color.blue);
//					g.drawString("O", j * CELL_SIZE + 32, i * CELL_SIZE + 32);
					strText = strPlayers[1];
					
				}
				
				int iCenterX = (j * CELL_SIZE) + (int) (0.5 * CELL_SIZE);
				int iCenterY = (i * CELL_SIZE) + (int) (0.5 * CELL_SIZE) ;
				
				g.drawString(strText, iCenterX - (fm.stringWidth(strText) / 2), iCenterY - (fm.getHeight() / 2) + fm.getAscent());
				
				
			}
		}

		
	}
	
	private void setNextPlayer() {
		iCurrentPlayer++;
		if (iCurrentPlayer > 2) {
			iCurrentPlayer = 1;
		}
	}
	
	private int checkWinner() {
		int iWinner = -1;
		
		int i, j;
		for (i = 0; i < BOARD_ROWS; i++) {
			int iValue = iBoard[i][0];
			if (iValue > 0) {
				iWinner = iValue;
				for (j = 1; j < BOARD_COLS; j++) {
					if (iBoard[i][j] != iValue) {
						iWinner = -1;
					}
				}
			}

			if (iWinner > 0) {
				break;
			}
		}
		
		if (iWinner < 0) {
			for (i = 0; i < BOARD_COLS; i++) {
				int iValue = iBoard[0][i];
				if (iValue > 0) {
					iWinner = iValue;
					for (j = 1; j < BOARD_ROWS; j++) {
						if (iBoard[j][i] != iValue) {
							iWinner = -1;
						}
					}
				}

				if (iWinner > 0) {
					break;
				}
			}
			
		}
		
		if (iWinner < 0) {
			int iValue = iBoard[0][0];
			if (iValue > 0) {
				iWinner = iValue;
				for (j = 1; j < BOARD_ROWS; j++) {
					if (iBoard[j][j] != iValue) {
						iWinner = -1;
					}
				}
			}
		}

		if (iWinner < 0) {
			int iValue = iBoard[0][2 - 0];
			if (iValue > 0) {
				iWinner = iValue;
				for (j = 1; j < BOARD_ROWS; j++) {
					if (iBoard[j][2 - j] != iValue) {
						iWinner = -1;
					}
				}
			}
		}

		
		return iWinner;
	}
	
	private boolean checkGameOver() {		
		boolean isGameOver = true;
		int i, j;
		
		for (i = 0; i < BOARD_ROWS; i++) {
			for (j = 0; j < BOARD_COLS; j++) {
				if (iBoard[i][j] == 0) {
					isGameOver = false;
				}
			}
		}
		return isGameOver;
		
	}
	
	private int getCellRow(int y) {
		int iRow;
		iRow = y / CELL_SIZE;
		return iRow;
	}

	private int getCellCol(int x) {
		int iCol;
		iCol = x / CELL_SIZE;
		return iCol;
	}

	
	private boolean markCell(int iRow, int iCol, int iValue) {
		boolean isValidMove = false;
		if (iBoard[iRow][iCol] == 0) {
			iBoard[iRow][iCol] = iValue;
			isValidMove = true;
		}
		
		return isValidMove;
	}
	
	public void restart() {
		int i, j;
		System.out.println("Restart Game");
		for (i = 0; i < BOARD_ROWS; i++) {
			for (j = 0; j < BOARD_COLS; j++) {
				iBoard[i][j] = 0;
			}
				
		}
	
		keepPlaying = true;
		iCurrentPlayer = 1;
		repaint();
		
	}
	
	public void mousePressed(MouseEvent e) {
		if (keepPlaying) {
			System.out.println("Mouse Pressed at: " + e.getX() + ", " + e.getY());
			if (markCell(getCellRow(e.getY()), getCellCol(e.getX()), iCurrentPlayer)) {
				repaint();

				int iWinner = checkWinner();
				if (iWinner > 0) {
					System.out.println("Winner: " + iWinner);
					
					JOptionPane.showMessageDialog(null, strPlayers[iWinner - 1] + " wins!");
					keepPlaying = false;
				}
			
				if (keepPlaying) {
					if (checkGameOver()) {
						System.out.println("No moves left");
						JOptionPane.showMessageDialog(null, "No moves left!");
						keepPlaying = false;
					}
				}
			
				if (keepPlaying) {
					setNextPlayer();
				}


			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}


}