package week4.exception.ex_throws;

public class Push_TB_DEPT {
	// TB_DEPT DEPTNO column : number Ÿ�� 
	
	String str = "100"; 
	// 1. String Ÿ�� �����͸� number Ÿ�� �÷��� �ִ� ���
	
	public int change(String str) throws NumberFormatException {
		// 2. String -> int ��ȯ �� number Ÿ�� Į���� ���� �ִ� ���	
		return Integer.parseInt(str);
	}
}
