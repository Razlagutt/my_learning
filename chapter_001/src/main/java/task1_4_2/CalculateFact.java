package task1_4_2;
public class CalculateFact {

	public static void main (String[] args){
	
		int n = 5;
		
	Fact fact = new Fact(n);
	if (n == 0){
		System.out.println("Factorial = " + 1);
	}
	else {
		System.out.println("Factorial of " + n + " is " + fact.calculate(n) );
	}
	
}
}