package dawnfall;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Projectile extends JLabel implements Trigger{
	
	Gameboard active_pane;
	
	public Projectile(Gameboard p)
	{
		active_pane = p;
		
		this.setBounds((int)(Math.random() * Gameboard.FRAME_X), (int)(Math.random() * Gameboard.FRAME_Y), 20, 20);
		this.setIcon(new ImageIcon("./resource/Projectile.png"));
		p.add(this);
		p.addTrigger(this);
	}
	
	@Override
	public void actionPerformed() {
		// TODO Auto-generated method stub
		System.out.println("Howdy. Howdy.");
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return active_pane;
	}

}
