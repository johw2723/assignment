package week4.NumberFormatException4;

public class TrueCase {
	// ���ڿ��� �Ǿ� �ִ� �����͸� ���ڷ� �����ϴ� ���
	String str = "100";
	
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
