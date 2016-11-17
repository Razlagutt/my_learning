package square;
public class TestSquare{
	public static void main (String[] args){
	
		double a = 2;
		double b = 2;
		double c = 3;
		int x1 = 1;
		int x2 = 4;
		int step = 1;
		
		Square square = new Square(a, b, c);
		for(int i = x1; i <= x2; i = i + step){
			System.out.println(square.calculate(i));
		}
		
		
		
	}
}