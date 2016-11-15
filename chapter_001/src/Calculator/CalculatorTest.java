package Calculator;
public class CalculatorTest {
	public static void main(String[] args){
		Calculator calculator = new Calculator();
		calculator.add(75, 25);
		calculator.showResult();
		calculator.subtract(75, 25);
		calculator.showResult();
		calculator.div(75, 25);
		calculator.showResult();
		calculator.multiple(75, 25);
		calculator.showResult();
		
	}	
	}