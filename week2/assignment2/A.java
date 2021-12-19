package week2.assignment2;

abstract class A {
	// 추상 클래스 : 하나 이상의 추상 메소드를 포함하는 클래스
	
	// 추상클래스 자체로는 클래스로의 역할을 하지 못하며 객체를 생성할 수 없다.
	// A a = new A();
		
	String a; // 일반 멤버 변수
		
	public void setA(String a) { // 일반 메소드
		this.a = a;
	}
		
	abstract void B2(); // 추상 메소드 : 접근지정자 private 사용 x ... 자식 클래스에서 호출해야 하므로
}
