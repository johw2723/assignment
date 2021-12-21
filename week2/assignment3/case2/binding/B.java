package week2.assignment3.case2.binding;

public class B {
	int a;
	int b;
	
	public int divide(int a, int b) {
		try{
			return a/b;
		} catch(ArithmeticException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
