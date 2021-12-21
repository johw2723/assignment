package week2.assignment2;

public interface B {
	// Java 8 부터는 default 접근 제한자와 static을 통해 메소드 바디를 가질 수 있게 되었다.
	
	default void default_body() {
		System.out.println("B 클래스의 default_body");
		// Change 'B2' to 'Default'
		// @Override로 재정의 할 수 있다.
		// 참조 변수로 함수 호출
	}
	
	static void static_body() {
		System.out.println("B 클래스의 static_body");
		// Change 'B3' to 'static'
		// 재정의가 불가능하다.
		// implements 한 클래스에서 반드시 구현할 필요가 없다.
		// 클래스 명으로 메소드 호출
	}

}
