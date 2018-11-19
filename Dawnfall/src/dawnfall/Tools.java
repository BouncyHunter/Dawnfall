package dawnfall;

import java.awt.Rectangle;

abstract class Tools {
	
	public static double getDistance(Rectangle r1,Rectangle r2)
	{
		double x1,y1,x2,y2;
		
		x1 = r1.getCenterX();
		y1 = r1.getCenterY();
		x2 = r2.getCenterX();
		y2 = r2.getCenterY();
		
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2); 		
	}

}
