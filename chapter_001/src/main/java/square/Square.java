package square;
public class Square {
	public double a;
	public double b;
	public double c;

	public Square(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		}
	
	public double calculate( int x) {
		return (this.a*( Math.pow(x, 2)) + this.b*x + this.c);
		
		}
}