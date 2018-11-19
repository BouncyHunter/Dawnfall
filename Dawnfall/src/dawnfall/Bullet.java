package dawnfall;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet extends TriggerAdapter{
	
	int direction;
	int status = 0;
	int cooldown = 0;
	Gameboard active_pane;
	double vector_x,vector_y;
	double change_accumulator_x,change_accumulator_y;
	
	
	public Bullet(int x,int y,Gameboard gb,double vx,double vy)
	{
		vector_x = vx;
		vector_y = vy;
		active_pane = gb;
		setBounds(x,y,20,20);
		setIcon(new ImageIcon("./resource/Bullet.png"));
		active_pane.addTrigger(this);
		active_pane.add(this);
	}

	@Override
	public void actionPerformed(int index) {
		change_accumulator_x += vector_x - (int)vector_x;
		change_accumulator_y += vector_y - (int)vector_y;
		cooldown ++;
		if(status == 0)
		{
			this.setBounds(getX() + (int)vector_x + (int)change_accumulator_x, getY() + (int)vector_y + (int)change_accumulator_y, 20, 20);
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
		if(change_accumulator_x >= 1) change_accumulator_x -= 1;
		if(change_accumulator_y >= 1) change_accumulator_y -= 1;
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return null;
	}

}
