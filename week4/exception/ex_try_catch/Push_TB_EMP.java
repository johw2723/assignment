package week4.exception.ex_try_catch;

public class Push_TB_EMP {
	// TB_EMP DEPTNO column : number -> varchar �� Ÿ�Ժ�ȯ  
	
	String str = "��"; 
	// 1. String Ÿ�� �����͸� varchar �÷��� �ִ� ��� 
	
	public int change(String str) {
		// String -> int ��ȯ ���� �� varchar Ÿ�� Į���� ���� �ִ� ���	
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}
}
