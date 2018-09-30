package dawnfall;

import javax.swing.JLayeredPane;

public class TriggerMage implements Trigger{
	int cooldown;
	Gameboard p;
	
	public TriggerMage() {
		cooldown = 0;
	}

	@Override
	public void actionPerformed() {
		// TODO Auto-generated method stub
		cooldown ++;
		if(cooldown == 50) {
			new ProjectileFireball(p);
			cooldown = 0;
		}
	}

	@Override
	public JLayeredPane getActivePane() {
		// TODO Auto-generated method stub
		return p;
	}
	
	public void setActivePane(Gameboard p) {
		this.p = p;
	}

}
