package dawnfall;

public interface Path {
	
	public int[] getMovementX();
	public int[] getMovementY();
	public void setMovementX(int[] a);
	public void setMovementY(int[] a);
	
	public int getCurrentMovementX();
	public int getCurrentMovementY();

}
