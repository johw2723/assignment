package week4.exception.ex_throws;

public class Push_TB_EMP {
	// TB_EMP DEPTNO column : number -> varchar �� Ÿ�Ժ�ȯ  
	
	String str = "��"; 
	// 1. String Ÿ�� �����͸� varchar �÷��� �ִ� ��� 
	
	public int change(String str) throws NumberFormatException {
		// 2. String -> int ��ȯ ���� �� varchar Ÿ�� Į���� ���� �ִ� ���	
		return Integer.parseInt(str);
	}
}
