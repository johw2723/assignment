package week2.assignment2;

public interface B {
	// Java 8 ���ʹ� default ���� �����ڿ� static�� ���� �޼ҵ� �ٵ� ���� �� �ְ� �Ǿ���.
	
	default void default_body() {
		System.out.println("B Ŭ������ default_body");
		// Change 'B2' to 'Default'
		// @Override�� ������ �� �� �ִ�.
		// ���� ������ �Լ� ȣ��
	}
	
	static void static_body() {
		System.out.println("B Ŭ������ static_body");
		// Change 'B3' to 'static'
		// �����ǰ� �Ұ����ϴ�.
		// implements �� Ŭ�������� �ݵ�� ������ �ʿ䰡 ����.
		// Ŭ���� ������ �޼ҵ� ȣ��
	}

}
