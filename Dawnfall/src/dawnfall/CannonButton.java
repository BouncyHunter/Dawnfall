package dawnfall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;


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
				//cooldown = 0;
				for(Trigger t : active_pane.getTriggerList())
				{
					if(t instanceof JComponent)
					{
						if(t.getRaces().contains("Enemy") && Tools.getDistance(((JComponent) t).getBounds(),CannonButton.this.getBounds()) <= 10000)
						{
							int x = (int) (((JComponent) t).getBounds().getCenterX() - CannonButton.this.getBounds().getCenterX());
							int y = (int) (((JComponent) t).getBounds().getCenterY() - CannonButton.this.getBounds().getCenterY());
							double z = Math.sqrt(x * x + y * y);
							new Bullet(getX(),getY(),gb,3 * x / z,3 * y / z);
						}
					}
				}
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
			new Bullet(getX(),getY(),active_pane,-3,0);
		}
		setBounds(getX() + movement_x[cooldown],getY() + movement_y[cooldown],20,20);
		
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Races getRaces() {
		// TODO Auto-generated method stub
		return new Races();
	}

}
