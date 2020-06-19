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
	int health = 100;
	
	ArrayList<Trigger> trigger_list = new ArrayList<Trigger>();
    ArrayList<Trigger> buffer_trigger = new ArrayList<Trigger>();
	
	public Gameboard() {
		setBounds(0,0,FRAME_X,FRAME_Y);
		health_bar = new JProgressBar(0,health);
		health_bar.setBounds((FRAME_X - DEADLINE_WIDTH) / 2, FRAME_Y - DEADLINE_HEIGHT, DEADLINE_WIDTH, DEADLINE_HEIGHT);
		health_bar.setBackground(Color.RED);
		main_timer = new Timer(100,new GBListener());
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
	
	public void addTrigger(Trigger t) {
		buffer_trigger.add(t);
	}
	
	public boolean takeDamage(int a) {
		int r_health = health;
		health = health - a;
		if(r_health == health) return false;
		else return true;
	}
	
	class GBListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(Trigger t : trigger_list) {
				t.actionPerformed();
			}
			for(Trigger t : buffer_trigger) {
				trigger_list.add(t);
			}
			buffer_trigger.removeAll(buffer_trigger);
		}
		
	}

}
