package dawnfall;

import java.util.Vector;

public interface Trigger {
	
	public void actionPerformed(int index);
	public Gameboard getActivePane();
	public Races getRaces();
	
}
