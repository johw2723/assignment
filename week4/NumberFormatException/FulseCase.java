package week4.NumberFormatException;

public class FulseCase {
	// ���ڿ��� �Ǿ� �ִ� �����͸� ���ڷ� �����ϴ� ���
	String str = "100A";
	
	public int transform() throws NumberFormatException {
		int value = Integer.parseInt(str);
		return value;
	}
	
}
