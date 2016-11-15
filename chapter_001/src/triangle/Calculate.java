package triangle;
public class Calculate{
	public static void main (String[] args){
		Point a = new Point(5, 0);
		Point b = new Point(5, 5);
		Point c = new Point(0, 5);
		
		Triangle triangle = new Triangle(a, b, c);
		double ab = a.distanceTo(b);
		double bc = b.distanceTo(c);
		double ca = c.distanceTo(a);
		System.out.println("ab " + ab );
		System.out.println("bc " + bc );
		System.out.println("ca " + ca );
		if (triangle.check()){
			System.out.println("Square of triangle is " + triangle.area());
		}
		else {
			System.out.println("It is not triangle");	
		}
		//  zadanie 2
		Side side1 = new Side (ab);
		Side side2 = new Side (bc);
		Side side3 = new Side (ca);
		if (side1.max(side2)){
			if (side1.max(side3)) {
				System.out.println("MaxSide is ab " + ab);
			}
			else {
				System.out.println("MaxSide is ca" + ca);
			}
			
		} else {
			if (side2.max(side3)) {
				System.out.println("MaxSide is bc " + bc);
			}
			else{
				System.out.println("MaxSide is ca " + ca);
			}
		} 
			

	
	}

		


	
	
}


