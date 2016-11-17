package task1_4_2;
public class Fact {
		
	public int n;


	public Fact(int n) {
		this.n = n;

	
		}
	public double calculate( int n) {
		int key = 1;
		int res= 1;
	while ( key < n){
		key++;
		res=res*key;
	}
	return res;
	
	}
	

	
}