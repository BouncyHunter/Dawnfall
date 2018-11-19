package dawnfall;

import java.awt.event.KeyEvent;

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
	public void actionPerformed(int index) {
		// TODO Auto-generated method stub
		System.out.print("=");
		cooldown ++;
		if(cooldown == 5) {
			System.out.println("Test attack!");
			new TestButton(p);
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

	@Override
	public Races getRaces() {
		// TODO Auto-generated method stub
		return new Races();
	}

}
