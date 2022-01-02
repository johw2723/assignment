package week4.exception.ex_throws;

public class Push_TB_DEPT {
	// TB_DEPT DEPTNO column : number 타입 
	
	String str = "100"; 
	// 1. String 타입 데이터를 number 타입 컬럼에 넣는 경우
	
	public int change(String str) throws NumberFormatException {
		// 2. String -> int 변환 후 number 타입 칼럼에 값을 넣는 경우	
		return Integer.parseInt(str);
	}
}
