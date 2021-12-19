package week2.assignment2;

public class C extends A implements B {

	public static void main(String[] args) {
		C c = new C();
		c.B2(); // 인터페이스의 메소드가 상위일 경우 : 인터페이스 메소드 출력
				// 추상클래스의 메소드가 상위일 경우 : 디버그 오류 
		
		B.B3(); // 인터페이스의 static method 호출 (클래스 명으로 호출)
		
		// abstract class A와 interface B 두 클래스의 메소드를 모두 따른다.
	}

	@Override
	public void B2() {
		// 미구현 함수는 모두 구현해 주어야 한다. (아닐 경우 추상 클래스로 변경)
		// 구현 함수 앞에는 반드시 public을 붙여야한다.
		System.out.println("인터페이스 재정의 B");
	}

	@Override
	void B2() {
		// 추상 메소드는 구현이 강요된다. (Add unimplemented methods)
		// 미구현시 자식 클래스도 추상 클래스가 되어야한다. (Make type '클래스명' abstract)
		System.out.println("추상클래스 A");
	}
	


}
