package dawnfall;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame{
	
	private Gameboard active_board;
	
	public Window()
	{
		this.setTitle("===TEST===");
		this.setBounds(0, 0, Gameboard.FRAME_X, Gameboard.FRAME_Y);
	}

	public Gameboard getActiveBoard() {
		return active_board;
	}

	public void setActiveBoard(Gameboard active_board) {
		this.active_board = active_board;
	}
	
	

}
