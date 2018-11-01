package dawnfall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CannonButton extends JButton implements Trigger , Path{
	
	int[] movement_x = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
			            -2,-2,-2,-2,-2,-2,-2,-2,-2,-2,
			            -2,-2,-2,-2,-2,-2,-2,-2,-2,-2,
			             2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
	int[] movement_y = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
			             2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        -2,-2,-2,-2,-2,-2,-2,-2,-2,-2,
                        -2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
	
	int cooldown = 0;
	Gameboard active_pane;
	
	public CannonButton(int x,int y,Gameboard gb) {
		active_pane = gb;
		setBounds(x,y,20,20);
		setIcon(new ImageIcon("./resource/CannonButton.png"));
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cooldown = 0;
				new Bullet(getX(),getY(),gb,3);
			}
			
		});
		gb.add(this);
		gb.addTrigger(this);
	}

	@Override
	public void actionPerformed(int index) {
		cooldown ++;
		if(cooldown >= 40) {
			cooldown = 0;
			new Bullet(getX(),getY(),active_pane,3);
		}
		setBounds(getX() + movement_x[cooldown],getY() + movement_y[cooldown],20,20);
		
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int[] getMovementX() {
		// TODO Auto-generated method stub
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
		return 0;
	}

	@Override
	public int getCurrentMovementY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
