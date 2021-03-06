package dawnfall;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Gameboard extends JLayeredPane{
	private Npc[] npcs;
	JProgressBar health_bar;
	public static final int FRAME_X = 600,FRAME_Y = 480,DEADLINE_WIDTH = 400,DEADLINE_HEIGHT = 30;
	Timer main_timer;
	int health = 100;
	
	public Gameboard() {
		setBounds(0,0,FRAME_X,FRAME_Y);
		health_bar = new JProgressBar(0,health);
		health_bar.setBounds((FRAME_X - DEADLINE_WIDTH) / 2, FRAME_Y - DEADLINE_HEIGHT, DEADLINE_WIDTH, DEADLINE_HEIGHT);
		health_bar.setBackground(Color.RED);
		main_timer = new Timer(20,new GBListener());
	}
	
	public void start()
	{
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
	
	public boolean takeDamage(int a) {
		int r_health = health;
		health = health - a;
		if(r_health == health) return false;
		else return true;
	}
	
	public void staticLabel(String text, int duration) {
		JLabel tempo_label = new JLabel(text);
		Timer tempo_timer = new Timer(duration,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove(tempo_label);
				
			}
			
		});
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
