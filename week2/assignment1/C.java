package week2.assignment1;

public class C extends A implements B {

	public static void main(String[] args) {
		C c = new C();
		c.A(); // B (�޼ҵ� ��ġ�� �ٲ㵵 ������ ���)
		
		// ��� �������̽��� �߻�Ŭ���� �� �������̽��� �޼ҵ带 ������.
	}

	@Override
	public void A() {
		// �̱��� �Լ��� ��� ������ �־�� �Ѵ�. (�ƴ� ��� �߻� Ŭ������ ����)
		// ���� �Լ� �տ��� �ݵ�� public�� �ٿ����Ѵ�.
		System.out.println("�������̽� B");
	}

	@Override
	void A() {
		// �߻� �޼ҵ�� ������ ����ȴ�. (Add unimplemented methods)
		// �̱����� �ڽ� Ŭ������ �߻� Ŭ������ �Ǿ���Ѵ�. (Make type 'Ŭ������' abstract)
		System.out.println("�߻�Ŭ���� A");
	}

}
