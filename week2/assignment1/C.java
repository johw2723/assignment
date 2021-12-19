package week2.assignment1;

public class C extends A implements B {

	public static void main(String[] args) {
		C c = new C();
		c.A(); // B (메소드 위치를 바꿔도 동일한 결과)
		
		// 결과 인터페이스와 추상클래스 중 인터페이스의 메소드를 따른다.
	}

	@Override
	public void A() {
		// 미구현 함수는 모두 구현해 주어야 한다. (아닐 경우 추상 클래스로 변경)
		// 구현 함수 앞에는 반드시 public을 붙여야한다.
		System.out.println("인터페이스 B");
	}

	@Override
	void A() {
		// 추상 메소드는 구현이 강요된다. (Add unimplemented methods)
		// 미구현시 자식 클래스도 추상 클래스가 되어야한다. (Make type '클래스명' abstract)
		System.out.println("추상클래스 A");
	}

}
