package dawnfall;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Trigger{
	
	int vector_x,vector_y;
	int gravity_y = 40;
	Gameboard active_pane;
	
	public Player(Gameboard gb,int x,int y)
	{
		active_pane = gb;
		setBounds(x,y,20,20);
		setIcon(new ImageIcon("./resource/Player.png"));
		gb.add(this);
		gb.addControllableTrigger(this);
	}

	@Override
	public void actionPerformed(int index) {
		// TODO Auto-generated method stub
		switch(index)
		{
		case Gameboard.UP:
			vector_y = 40;
			break;
		case Gameboard.DOWN:
			vector_y -= 5;
			break;
		case Gameboard.LEFT:
			if(vector_x >= -40) vector_x -= 5;
		    break;
		case Gameboard.RIGHT:
			if(vector_x <= 40) vector_x += 5;
			break;
		default:
			setBounds(Math.abs(getX() + vector_x),Math.abs(getY() - vector_y),getWidth(),getHeight());
			vector_y -= gravity_y;
			break;
		}
	}

	@Override
	public Gameboard getActivePane() {
		// TODO Auto-generated method stub
		return null;
	}

}
