package triangle;

public class Side {
	public double lenth;

	public Side (double lenth) {
	this.lenth = lenth;
		
	}
	

	public boolean max (Side side) {
	if (this.lenth > side.lenth)	{
	return true;	
	}
	else {
	return false;	
	}
		
		}
}