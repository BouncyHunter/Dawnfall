package dawnfall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TestButton extends JButton implements Trigger{
	
	Gameboard active_pane;
	int cooldown;
	
	public TestButton(Gameboard gb) {
		cooldown = 0;
		active_pane = gb;
	    this.setIcon(new ImageIcon("./resource/Button.png"));
	    this.setBounds((int)(Math.random() * Gameboard.FRAME_X), (int)(Math.random() * Gameboard.FRAME_Y), 20, 20);
	    this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Projectile(active_pane);
			}
	    	
	    });
	    gb.addTrigger(this);
	    gb.add(this);
	}

	@Override
	public void actionPerformed() {
		// TODO Auto-generated method stub
		cooldown ++;
		if(cooldown >= 50) {
			this.setIcon(new ImageIcon("./resource/Button2.png"));
			cooldown = 0;
		}
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return active_pane;
	}
	
	
	

}
