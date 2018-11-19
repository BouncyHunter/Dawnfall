package dawnfall;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Projectile extends TriggerAdapter implements Path{
	
	Gameboard active_pane;
	
	int[] movement_x = {3};
	int[] movement_y = {2};
	
	Races races;
	
	public Projectile(Gameboard p)
	{
		active_pane = p;
		
		this.setBounds((int)(Math.random() * Gameboard.FRAME_X), (int)(Math.random() * Gameboard.FRAME_Y), 20, 20);
		this.setIcon(new ImageIcon("./resource/Projectile.png"));
		p.add(this);
		p.addTrigger(this);
		races = new Races();
		races.setRaces("Enemy", true);
	}
	
	@Override
	public void actionPerformed(int index) {
		setBounds(getBounds().x + getCurrentMovementX(),getBounds().y + getCurrentMovementY(),20,20);
		if(getBounds().x > Gameboard.FRAME_X && getBounds().y > Gameboard.FRAME_Y)
		{
			active_pane.remove(this);
			active_pane.removeTrigger(this);
		}
	}
	

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return active_pane;
	}

	@Override
	public int[] getMovementX() {
		return movement_x;
	}

	@Override
	public int[] getMovementY() {
		// TODO Auto-generated method stub
		return movement_y;
	}

	@Override
	public void setMovementX(int[] a) {
		movement_x = a;
	}

	@Override
	public void setMovementY(int[] a) {
		movement_y = a;
	}

	@Override
	public int getCurrentMovementX() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getCurrentMovementY() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public Races getRaces()
	{
		return races;
	}

}
