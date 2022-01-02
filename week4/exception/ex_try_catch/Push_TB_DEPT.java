package week4.exception.ex_try_catch;

public class Push_TB_DEPT {
	// TB_DEPT DEPTNO column : number 타입 
	
	String str = "100"; 
	// 1. String 타입 데이터를 number 타입 컬럼에 넣는 경우
	
	public int change(String str) {
		// String -> int 변환 후 number 타입 칼럼에 값을 넣는 경우	
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}
}
