package week4.NumberFormatException;

public class TrueCase {
	// ���ڿ��� �Ǿ� �ִ� �����͸� ���ڷ� �����ϴ� ���
	String str = "100";
	
	public int transform() throws NumberFormatException {
		int value = Integer.parseInt(str);
		return value;
	}
	
}
