package week4.NumberFormatException2;

public class FulseCase {
	// 문자열로 되어 있는 데이터를 숫자로 변경하는 경우
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
