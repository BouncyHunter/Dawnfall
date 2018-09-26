package dawnfall;

import javax.swing.JLabel;

public class Projectile extends JLabel{
	private int vector_x,vector_y;
	private int speed;
	public void action()
	{
		
	}
	public int getVector_x() {
		return vector_x;
	}
	public void setVector_x(int vector_x) {
		this.vector_x = vector_x;
	}
	public int getVector_y() {
		return vector_y;
	}
	public void setVector_y(int vector_y) {
		this.vector_y = vector_y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
