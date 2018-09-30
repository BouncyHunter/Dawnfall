package dawnfall;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Gameboard extends JLayeredPane{
	Timer[] text_timer;
	//private Npc[] npcs;
	JProgressBar health_bar;
	public static final int FRAME_X = 600,FRAME_Y = 480,DEADLINE_WIDTH = 400,DEADLINE_HEIGHT = 30;
	//public static final int TEXT_STACK = 5;
	//int timer_pointer;
	Timer main_timer;
	ArrayList<Projectile> projectile_list = new ArrayList<Projectile>();
	int health = 100;
	
	Trigger[] triggers;
	
	public Gameboard() {
		setBounds(0,0,FRAME_X,FRAME_Y);
		health_bar = new JProgressBar(0,health);
		health_bar.setBounds((FRAME_X - DEADLINE_WIDTH) / 2, FRAME_Y - DEADLINE_HEIGHT, DEADLINE_WIDTH, DEADLINE_HEIGHT);
		health_bar.setBackground(Color.RED);
		main_timer = new Timer(500,new GBListener());
	}
	
	/*public void intitalizeTimer() {
		text_timer = new Timer[TEXT_STACK];
		timer_pointer = 0;
	}*/
	
	public void start()
	{
		main_timer.start();
	}
	

	/*public Npc[] getNpcs() {
		return npcs;
	}

	public void setNpcs(Npc[] npcs) {
		this.npcs = npcs;
	}*/
	
	public void victory() {
		
	}
	
	public void addProjectile(Projectile p) {    //CHOICE : interface or class ?
		projectile_list.add(p);
		if(p instanceof JLabel) {
			add(p);
		}
	}
	
	public boolean takeDamage(int a) {
		int r_health = health;
		health = health - a;
		if(r_health == health) return false;
		else return true;
	}
	
	public void createStaticLabel(String text, int duration,Rectangle r) {
		JLabel tempo_label = new JLabel(text);
		tempo_label.setBounds(r);
		add(tempo_label);
		Timer tempo_timer = new Timer(duration,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove(tempo_label);
			}
			
		});
		tempo_timer.setRepeats(false);
		tempo_timer.start();
	}
	
	class GBListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(Trigger t : triggers) {
				t.actionPerformed();
			}
			for(Projectile p:projectile_list)
			{
				if(!p.action()) {
					projectile_list.remove(p);
				}
			}
		}
		
	}

}
