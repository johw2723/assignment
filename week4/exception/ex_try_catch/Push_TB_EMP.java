package week4.exception.ex_try_catch;

public class Push_TB_EMP {
	// TB_EMP DEPTNO column : number -> varchar 로 타입변환  
	
	String str = "백"; 
	// 1. String 타입 데이터를 varchar 컬럼에 넣는 경우 
	
	public int change(String str) {
		// String -> int 변환 실패 후 varchar 타입 칼럼에 값을 넣는 경우	
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}
}
