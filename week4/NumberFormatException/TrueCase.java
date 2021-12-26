package week4.NumberFormatException;

public class TrueCase {
	// 문자열로 되어 있는 데이터를 숫자로 변경하는 경우
	String str = "100";
	
	public int transform() throws NumberFormatException {
		int value = Integer.parseInt(str);
		return value;
	}
	
}
