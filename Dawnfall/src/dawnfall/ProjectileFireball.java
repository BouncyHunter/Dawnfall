package dawnfall;

import java.awt.Color;

import javax.swing.JLabel;

public class ProjectileFireball extends JLabel implements Projectile{
	
	public ProjectileFireball(Gameboard gb) {
		this.setText("»ğ");
		this.setForeground(Color.RED);
		this.setBounds((int)(Math.random() * (Gameboard.FRAME_X)), 0, 20, 20);
		gb.addProjectile(this);
	}

	@Override
	public boolean action() {
		this.setBounds(getX(), getY() + 1, getWidth(), getHeight());
		if(this.getY() >= Gameboard.FRAME_Y) {
			return false;
		}
		return true;
	}

}
