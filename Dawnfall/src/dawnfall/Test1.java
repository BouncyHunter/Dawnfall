package dawnfall;

import javax.swing.JFrame;

public class Test1 {
	
	JFrame main_frame;
	Gameboard main_board;
	Npc[] npcs;
	
	public Test1() {
		main_board = new Gameboard();
		main_frame = new JFrame("||TEST||");
		main_frame.setBounds(0, 0, Gameboard.FRAME_X, Gameboard.FRAME_Y);
		main_frame.setLayeredPane(main_board);
		npcs = new Npc[2];
		for(int i = 1;i <= 2;i ++)
		{
			npcs[i - 1] = new Npc() {
				public void action() {
					getActivePane().add(ProjectileFactory.create(ProjectileFactory.FIREBALL));
				}
			};
		}
	}
	
	public static void main(String[] args) {
		new Test1();
	}

}
