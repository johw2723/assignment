package week4.exception.ex_try_catch;

public class Push_TB_DEPT {
	// TB_DEPT DEPTNO column : number Ÿ�� 
	
	String str = "100"; 
	// 1. String Ÿ�� �����͸� number Ÿ�� �÷��� �ִ� ���
	
	public int change(String str) {
		// String -> int ��ȯ �� number Ÿ�� Į���� ���� �ִ� ���	
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}
}
