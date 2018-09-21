package dawnfall;

import javax.swing.JLabel;

public class ProjectileFactory {
	public static final int FIREBALL = 1;
	public JLabel create(int id) {
	JLabel label = new JLabel();
		switch(id)
		{
		case FIREBALL:
			label.setBounds((int) ((Gameboard.FRAME_X - 20)* Math.random()), 0, 20, 20);
		}
	}

}
