package week4.NumberFormatException2;

public class FulseCase {
	// ���ڿ��� �Ǿ� �ִ� �����͸� ���ڷ� �����ϴ� ���
	String str = "100A";
	
	public int transform() {
		int value = 0;
		try {
			value = Integer.parseInt(str);			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}	
		return value;
	}
	
}
