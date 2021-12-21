package week2.assignment2;

public class C implements A, B {
	

	

	public static void main(String[] args) {
		C c = new C();
		c.default_body(); // default_C 
		c.static_body();  // static_C 
		// 인터페이스의 메소드는 반드시 구현해야하고, 이는 오버라이드가 강제되기 때문에, 상속 받은 클래스에서 작성한 메소드를 따른다.
		
		A.static_body(); // A 클래스의 static_body
		//A.default_body(); static main 접근 불가
		B.static_body(); // B 클래스의 static_body
		//B.default_body(); static main 접근 불가
		
		c.call_super();
		
	}
	
	public void default_body() {
		System.out.println("default_C");
	}

	public void static_body() {
		System.out.println("static_C");
	}
	
	public void call_super() {
		A.super.default_body(); // A 클래스의 default_body
		B.super.default_body(); // B 클래스의 default_body
	}

}
