package dawnfall;

import java.awt.Color;

import javax.swing.JLabel;

public class ProjectileFactory {
	public static final int FIREBALL = 1;
	public static Projectile create(int id) {
	Projectile p = null;
		switch(id)
		{
		case FIREBALL:
			p = new Projectile() {
				public void action() {
					this.setBounds(this.getX() + getVector_x(),this.getY() + getVector_y(),getWidth(),getHeight());
					this.setDuration(this.getDuration() + 1);
					if(this.getDuration() >= 180)
					{
						this.getActivePane().remove(this);
						this.getActivePane().takeDamage(5);
						this.getActivePane().createStaticLabel("-5", 5000, this.getBounds());
					}
				}
			};
			p.setText("»ð");
			p.setForeground(Color.red);
			p.setVector_x(0);
			p.setVector_y(5);
			p.setBounds((int) ((Gameboard.FRAME_X - 20)* Math.random()), 0, 20, 20);
		}
		return p;
	}

}
