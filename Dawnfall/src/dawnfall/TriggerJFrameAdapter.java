package dawnfall;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class TriggerJFrameAdapter extends JFrame implements Trigger{

	@Override
	public void actionPerformed(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Races getRaces() {
		// TODO Auto-generated method stub
		return new Races();
	}

}
