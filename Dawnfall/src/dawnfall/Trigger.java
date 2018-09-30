package dawnfall;

import javax.swing.JLayeredPane;

public interface Trigger {
	
	public void actionPerformed();
	public JLayeredPane getActivePane();

}
