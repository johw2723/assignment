package week4.exception.ex_try_catch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Call_DAO {
	private Connection con;
	private PreparedStatement pstmt;
	private String query;
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "scott";
	private static String password = "tiger";
	
	private static Call_DAO instance = new Call_DAO();
	private Call_DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("����̹� ȣ�� ����");
		}
	}
	
	public static Call_DAO getInstance() {
		return instance;
	}
	
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
		
		// ��ü����
		Call_DAO dao = new Call_DAO();
		Push_TB_EMP emp = new Push_TB_EMP();
		Push_TB_DEPT dept = new Push_TB_DEPT();

		/* exception ex_throws ���� ���� (����ó���� ȣ�� �޴� ������ ���������� �� ���)
		 * TB_EMP - DEPTNO �÷� Ÿ�� : VARCHAR 
		 * TB_DEPT - DEPTNO �÷� Ÿ�� : NUMBER
		 */
		
		//dao.update_emp(emp.str); // str = "��" - ������ ���� : change �޼���� ���ؼ� int ���� �ޱ� ����
		dao.update_emp(emp.change(emp.str)); // str = "��" NumberFormatException ���� �߻� 
		//dao.update_dept(dept.str); // str = "100" - ������ ���� : change �޼���� ���ؼ� int ���� �ޱ� ����
		dao.update_dept(dept.change(dept.str)); // str = "100" NumberFormatException ���� �̹߻�
			
		// ���
		// dao.update_emp() ���� �߻� -> TB_EMP DEPTNO �� ��ȭ NULL -> 0 (return ������ ������ ������ �ʱⰪ)
		// ���⼭ ���̺� TB_EMP�� DEPTNO �÷��� Ÿ���� VARCHAR Ÿ���ε� int���� �ް� �� �Է��� �� �� Ȯ���� �� �ִ�.
		
		// dao.update_dept() ���� ���� -> TB_DEPT DEPTNO �� ��ȭ NULL -> 100
	}
	
	// EMP ���̺� DEPTNO Į��(VARCHAR Ÿ��) �� ���� 
	public void update_emp(int value) {
		System.out.println("update_emp ����");
		try{
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			query = "UPDATE TB_EMP SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, value);
			pstmt.executeUpdate();
			con.commit();
		} catch(Exception e) {
			e.printStackTrace();
			if(con != null) {
				try {
					con.rollback();
					System.out.println("rollback");
				} catch (SQLException sqle) {}
			}
		} finally {
			try { if(pstmt != null) pstmt.close();} 
			catch(Exception e) { e.printStackTrace(); }
			
			try { if(con != null) con.close();} 
			catch(Exception e) { e.printStackTrace();}		
			System.out.println("update_emp ����");
		}
	}
	
	// DEPT ���̺� DEPTNO Į��(NUMBER Ÿ��) �� ���� 
	public void update_dept(int value) {
		System.out.println("update_dept ����");
		try{
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			query = "UPDATE TB_DEPT SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, value);
			pstmt.executeUpdate();
			con.commit();
		} catch(Exception e) {
			e.printStackTrace();
			if(con != null) {
				try {
					con.rollback();
					System.out.println("rollback");
				} catch (SQLException sqle) {}
			}
		} finally {
			try { if(pstmt != null) pstmt.close();} 
			catch(Exception e) { e.printStackTrace(); }
			
			try { if(con != null) con.close();} 
			catch(Exception e) { e.printStackTrace();}		
			System.out.println("update_dept ����");
		}
	}
	
}
