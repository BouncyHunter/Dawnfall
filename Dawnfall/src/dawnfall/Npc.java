package dawnfall;

import javax.swing.JLayeredPane;

public class Npc {
	private String name;
	private int max_cooldown;
	private double cooldown,cooldown_boost;
	private int health;
	private int mana;
	private boolean active;
	JLayeredPane active_pane;
	
	public Npc()
	{
		
	}
	
	void setName(String s)
	{
		name = s;
	}
	String getName()
	{
		return name;
	}	
	void setActive(boolean b)
	{
		active = b;
	}
	boolean getActive()
	{
		return active;
	}
	void setActivePane(JLayeredPane p)
	{
		active_pane = p;
	}
	JLayeredPane getActivePane()
	{
		return active_pane;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
    
	public void action()
	{
		
	}
	
	public void triggerOnHeal(int num,Npc target)
	{
		
	}
	
	public void triggerOnHit(int num,Npc target)
	{
		
	}
	
	public void takeDamage(int num)
	{
		
	}
	
	public void takeHeal(int num)
	{
		
	}

	public double getCooldown() {
		return cooldown;
	}

	public void setCooldown(double cooldown) {
		this.cooldown = cooldown;
	}

	public int getMaxCooldown() {
		return max_cooldown;
	}

	public void setMaxCooldown(int max_cooldown) {
		this.max_cooldown = max_cooldown;
	}

	public double getCooldownBoost() {
		return cooldown_boost;
	}

	public void setCooldownBoost(double cooldown_boost) {
		this.cooldown_boost = cooldown_boost;
	}
	
}
