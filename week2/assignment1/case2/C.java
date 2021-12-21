package week2.assignment1.case2;

public class C implements A, B {
	
	public static void main(String[] args) {
		C c = new C();
		c.Test(); // C 클래스
		// 두 인터페이스를 따라 C 클래스에서도 동일한 메스드명의 메소드를 작성해야하기 때문에 C클래스가 따르는 메소드는 C클래스의 메소드이다.
	}

	public void Test() {System.out.println("C 클래스");}

}
