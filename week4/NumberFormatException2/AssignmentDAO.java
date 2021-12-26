package week4.NumberFormatException2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AssignmentDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private String query;
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "scott";
	private static String password = "tiger";
	
	public static void main(String[] args) {	
		try {
			Class.forName(driver);
			System.out.println("jdbc driver �ε� ����");
			DriverManager.getConnection(url, user, password);
			System.out.println("����Ŭ ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver �ε� ����");
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����");
		}
				
		AssignmentDAO dao = new AssignmentDAO();
		
		TrueCase a = new TrueCase();
		FulseCase b = new FulseCase();

		// ���� ����
		int true_value = a.transform(); // int true_value : 100  
		dao.update_emp(true_value); // ���� �� ���� - TB_EMP : DEPTNO �÷� �� : 100���� ����
		dao.update_dept(true_value); // ���� �� ���� - TB_DEPT : DEPTNO �÷� �� : 100���� ����
		
		int false_value = b.transform(); // NumberFormatException
		dao.update_emp(false_value); // ���� �� ���� - TB_EMP : DEPTNO �÷� �� : 0���� ���� 
		dao.update_dept(false_value); // ���� �� ���� - TB_DEPT : DEPTNO �÷� �� : 0���� ����
		// why 0 ? = transform()���� int value�� 0���� �ʱ�ȭ�Ǿ��־��� ������ Integer.parseInt(str) ������ ����Ǵ� ���� �̽���Ǿ�� ���� �ʱ�ȭ �� 0�� ���ϵǾ���.
		
	}
	
	// emp ���̺� TEST Į�� �� ����
	public void update_emp(int num) {
		System.out.println("update_emp ����");
		try{
			con = DriverManager.getConnection(url, user, password);
			query = "UPDATE TB_EMP SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {			
				pstmt.close();			
				con.close();
				System.out.println("update_emp ����");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// dept ���̺� TEST Į�� �� ����
	public void update_dept(int num) {
		System.out.println("update_dept ����");
		try{
			con = DriverManager.getConnection(url, user, password);
			query = "UPDATE TB_DEPT SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {			
				pstmt.close();			
				con.close();
				System.out.println("update_dept ����");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
