package dawnfall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class Gameboard extends JLayeredPane{
	private Npc[] npcs;
	JLabel danger;
	public static final int FRAME_X = 600,FRAME_Y = 480,DEADLINE_WIDTH = 400,DEADLINE_HEIGHT = 30;
	Timer main_timer;
	
	public Gameboard() {
		setBounds(0,0,FRAME_X,FRAME_Y);
		danger = new JLabel();
		danger.setBounds((FRAME_X - DEADLINE_WIDTH) / 2, FRAME_Y - DEADLINE_HEIGHT, DEADLINE_WIDTH, DEADLINE_HEIGHT);
		main_timer = new Timer(20,new GBListener());
		main_timer.start();
	}

	public Npc[] getNpcs() {
		return npcs;
	}

	public void setNpcs(Npc[] npcs) {
		this.npcs = npcs;
	}
	
	public void victory() {
		
	}
	
	class GBListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(npcs.length == 0)
			{
				main_timer.stop();
				victory();
				return;
			}
			for(Npc n : npcs) {
				n.setCooldown(n.getCooldown() + n.getCooldownBoost());
				if(n.getCooldown() >= n.getMaxCooldown())
				{
					n.setCooldown(0);
					n.action();
				}
			}
		}
		
	}

}
