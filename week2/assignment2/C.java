package week2.assignment2;

public class C implements A, B {
	

	

	public static void main(String[] args) {
		C c = new C();
		c.default_body(); // default_C 
		c.static_body();  // static_C 
		// �������̽��� �޼ҵ�� �ݵ�� �����ؾ��ϰ�, �̴� �������̵尡 �����Ǳ� ������, ��� ���� Ŭ�������� �ۼ��� �޼ҵ带 ������.
		
		A.static_body(); // A Ŭ������ static_body
		//A.default_body(); static main ���� �Ұ�
		B.static_body(); // B Ŭ������ static_body
		//B.default_body(); static main ���� �Ұ�
		
		c.call_super();
		
	}
	
	public void default_body() {
		System.out.println("default_C");
	}

	public void static_body() {
		System.out.println("static_C");
	}
	
	public void call_super() {
		A.super.default_body(); // A Ŭ������ default_body
		B.super.default_body(); // B Ŭ������ default_body
	}

}
