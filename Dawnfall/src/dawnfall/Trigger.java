package dawnfall;

import java.awt.event.KeyEvent;

public interface Trigger {
	
	public void actionPerformed(int index);
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void keyTyped(KeyEvent e);
	public Gameboard getActivePane();

}
