package week2.assignment1;

public class C extends A, B {
	// 자바는 다중상속을 허용하지 않는다.

	public static void main(String[] args) {
		C c = new C();
		c.setA("C");
	}

	void methodA() {
		
	}
}
