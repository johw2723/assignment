package week2.assignment2;

abstract class A {
	// �߻� Ŭ���� : �ϳ� �̻��� �߻� �޼ҵ带 �����ϴ� Ŭ����
	
	// �߻�Ŭ���� ��ü�δ� Ŭ�������� ������ ���� ���ϸ� ��ü�� ������ �� ����.
	// A a = new A();
		
	String a; // �Ϲ� ��� ����
		
	public void setA(String a) { // �Ϲ� �޼ҵ�
		this.a = a;
	}
		
	abstract void B2(); // �߻� �޼ҵ� : ���������� private ��� x ... �ڽ� Ŭ�������� ȣ���ؾ� �ϹǷ�
}
