package week2.assignment2;

public class C extends A implements B {

	public static void main(String[] args) {
		C c = new C();
		c.B2(); // �������̽��� �޼ҵ尡 ������ ��� : �������̽� �޼ҵ� ���
				// �߻�Ŭ������ �޼ҵ尡 ������ ��� : ����� ���� 
		
		B.B3(); // �������̽��� static method ȣ�� (Ŭ���� ������ ȣ��)
		
		// abstract class A�� interface B �� Ŭ������ �޼ҵ带 ��� ������.
	}

	@Override
	public void B2() {
		// �̱��� �Լ��� ��� ������ �־�� �Ѵ�. (�ƴ� ��� �߻� Ŭ������ ����)
		// ���� �Լ� �տ��� �ݵ�� public�� �ٿ����Ѵ�.
		System.out.println("�������̽� ������ B");
	}

	@Override
	void B2() {
		// �߻� �޼ҵ�� ������ ����ȴ�. (Add unimplemented methods)
		// �̱����� �ڽ� Ŭ������ �߻� Ŭ������ �Ǿ���Ѵ�. (Make type 'Ŭ������' abstract)
		System.out.println("�߻�Ŭ���� A");
	}
	


}
