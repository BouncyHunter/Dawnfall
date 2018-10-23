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
	private Window active_window;
	//private Npc[] npcs;
	JProgressBar health_bar;
	public static final int FRAME_X = 600,FRAME_Y = 480,DEADLINE_WIDTH = 400,DEADLINE_HEIGHT = 30;
	

	//public static final int TEXT_STACK = 5;
	//int timer_pointer;
	private Timer main_timer;
	int health = 100;
	
	private ArrayList<Trigger> trigger_list = new ArrayList<Trigger>();
    private ArrayList<Trigger> buffer_trigger = new ArrayList<Trigger>();
    private ArrayList<Trigger> exile_trigger = new ArrayList<Trigger>();
	
	public Gameboard() {
		setBounds(0,0,FRAME_X,FRAME_Y);
		health_bar = new JProgressBar(0,health);
		health_bar.setBounds((FRAME_X - DEADLINE_WIDTH) / 2, FRAME_Y - DEADLINE_HEIGHT, DEADLINE_WIDTH, DEADLINE_HEIGHT);
		health_bar.setBackground(Color.RED);
		main_timer = new Timer(100,new GBListener());
	}
	
	public Window getActiveWindow() {
		return active_window;
	}

	public void setActiveWindow(Window active_window) {
		this.active_window = active_window;
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
	
	public Timer getMainTimer() {
		return main_timer;
	}

	public void setMainTimer(Timer main_timer) {
		this.main_timer = main_timer;
	}

	public ArrayList<Trigger> getTriggerList() {
		return trigger_list;
	}

	public void setTriggerList(ArrayList<Trigger> trigger_list) {
		this.trigger_list = trigger_list;
	}

	public ArrayList<Trigger> getBufferTrigger() {
		return buffer_trigger;
	}

	public void setBufferTrigger(ArrayList<Trigger> buffer_trigger) {
		this.buffer_trigger = buffer_trigger;
	}

	public ArrayList<Trigger> getExileTrigger() {
		return exile_trigger;
	}

	public void setExileTrigger(ArrayList<Trigger> exile_trigger) {
		this.exile_trigger = exile_trigger;
	}

	public void victory() {
		
	}
	
	public void addTrigger(Trigger t) {
		buffer_trigger.add(t);
	}
	
	public void removeTrigger(Trigger t) {
		if(trigger_list.contains(t) && !exile_trigger.contains(t))
		{
			exile_trigger.add(t);
		}
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
				t.actionPerformed(0);
			}
			for(Trigger t : buffer_trigger) {
				trigger_list.add(t);
			}
			trigger_list.removeAll(exile_trigger);
			exile_trigger.removeAll(exile_trigger);
			buffer_trigger.removeAll(buffer_trigger);
			active_window.setFocusable(true);
		}
		
	}

}
