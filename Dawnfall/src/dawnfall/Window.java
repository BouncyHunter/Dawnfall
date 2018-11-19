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
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("I got something!");
				for(Trigger t : active_board.getTriggerList())
				{
					t.keyPressed(e);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("I obtained something!");
				for(Trigger t : active_board.getTriggerList())
				{
					t.keyReleased(e);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("I collected something!");
				for(Trigger t : active_board.getTriggerList())
				{
					t.keyTyped(e);
				}
			}
			
		});
	}

	public Gameboard getActiveBoard() {
		return active_board;
	}

	public void setActiveBoard(Gameboard active_board) {
		this.active_board = active_board;
	}
	
	

}
