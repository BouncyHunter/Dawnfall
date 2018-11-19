package dawnfall;

import java.util.Vector;

public class Races {
	
	private Vector v;
	
	public Races()
	{
		v = new Vector();
	}
	
	public void setRaces(String str,boolean b)
	{
		if(b && !v.contains(str))
		{
			v.add(str);
		}else if(v.contains(str) && !b)
		{
			v.remove(str);
		}
	}
	
	public boolean contains(String str)
	{
		return v.contains(str);
	}

}
