package week2.assignment2;

public interface B {
	// Java 8 ���ʹ� default ���� �����ڿ� static�� ���� �޼ҵ� �ٵ� ���� �� �ְ� �Ǿ���.
	
	/*void B1() {
		System.out.println("B1");
		// Remove method body
	}*/
	
	default void B2() {
		System.out.println("B2");
		// Change 'B2' to 'Default'
		// @Override�� ������ �� �� �ִ�.
		// ���� ������ �Լ� ȣ��
	}
	
	static void B3() {
		System.out.println("B3");
		// Change 'B3' to 'static'
		// �����ǰ� �Ұ����ϴ�.
		// implements �� Ŭ�������� �ݵ�� ������ �ʿ䰡 ����.
		// Ŭ���� ������ �޼ҵ� ȣ��
	}

}
