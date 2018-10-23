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
		if(cooldown == 50) {
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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
