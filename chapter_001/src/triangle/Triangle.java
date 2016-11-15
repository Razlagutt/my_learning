package triangle;
public class Triangle {
	public Point a;
	public Point b;
	public Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		}
	
	
	public double area() {
		double ab = a.distanceTo(b);
		double bc = b.distanceTo(c);
		double ca = c.distanceTo(a);
		double p = (ab + bc + ca) / 2.0;
		double square = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
		return 	square;
	
		}
	boolean check () {
		double ab = a.distanceTo(b);
		double bc = b.distanceTo(c);
		double ca = c.distanceTo(a);
		if((ab < bc+ca)&&(bc < ab+ca)&&(ca < bc+ab)) {
			return true;
		} else {
			return false;
		}
		}
	

}