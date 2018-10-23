package dawnfall;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet extends TriggerAdapter{
	
	int direction;
	int status = 0;
	int cooldown = 0;
	Gameboard active_pane;
	
	public static final int UP = 0,RIGHT = 1,DOWN = 2,LEFT = 3;
	
	public Bullet(int x,int y,Gameboard gb,int dir)
	{
		active_pane = gb;
		dir = direction;
		setBounds(x,y,20,20);
		setIcon(new ImageIcon("./resource/Bullet.png"));
		active_pane.addTrigger(this);
		active_pane.add(this);
	}

	@Override
	public void actionPerformed(int index) {
		cooldown ++;
		if(status == 0)
		{
			this.setBounds(getX() - 3, getY(), 20, 20);
			if(cooldown >= 30)
			{
				status ++;
				cooldown = 0;
				setIcon(new ImageIcon("./resource/Explode.png"));
			}
		}else{
			if(cooldown >= 10)
			{
				active_pane.remove(this);
				active_pane.removeTrigger(this);
				active_pane.repaint();
			}
		}
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return null;
	}

}
