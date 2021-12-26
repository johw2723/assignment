package week4.NumberFormatException5;

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

		/* ���� ����
		 * TB_EMP - DEPTNO �÷� Ÿ�� : VARCHAR 
		 * TB_DEPT - DEPTNO �÷� Ÿ�� : NUMBER
		 */
		String str_value = a.str; // String str_value : "100A" 
		dao.update_emp(str_value); // String ���� VARCHAR Ÿ�� Į���� ���� ��� (true)
		dao.update_dept(str_value); // String ���� NUMBER Ÿ�� Į���� ���� ��� (false)
		
		// VARCHAR ������ Ÿ���� ������ �÷��� int �� ���� �־ ���� �Էµ� 
	}
	
	// emp ���̺� TEST Į�� �� ����
	public void update_emp(String str) {
		System.out.println("update_emp ����");
		try{
			con = DriverManager.getConnection(url, user, password);
			query = "UPDATE TB_EMP SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, str);
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
	public void update_dept(String str) {
		System.out.println("update_dept ����");
		try{
			con = DriverManager.getConnection(url, user, password);
			query = "UPDATE TB_DEPT SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, str);
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
