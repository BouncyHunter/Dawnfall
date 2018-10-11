package dawnfall;

import javax.swing.JLayeredPane;

public class TriggerMage implements Trigger{
	int cooldown;
	Gameboard p;
	
	public TriggerMage(Gameboard g) {
		p = g;
		cooldown = 0;
		System.out.println("I've joined the battlefield!");
	}

	@Override
	public void actionPerformed() {
		// TODO Auto-generated method stub
		System.out.println("Charging...");
		cooldown ++;
		if(cooldown == 50) {
			System.out.println("Test attack!");
			new Projectile(p);
			cooldown = 0;
		}
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return p;
	}
	
	public void setActivePane(Gameboard p) {
		this.p = p;
	}

}
