package week2.assignment3.case1;

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
			System.out.println("jdbc driver 로딩 성공");
			DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
				
		AssignmentDAO dao = new AssignmentDAO();
		//dao.update_dept_no(10);
		
		A a = new A();
		B b = new B();

		try{
			int resultA = a.divide(50, 0);
			dao.update_dept_no(resultA);
			
			int resultB = b.divide(50, 1);
			dao.update_dept_no(resultB);
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}		
	}
	
	public void update_dept_no(int num) {
		System.out.println("update");
		try{
			con = DriverManager.getConnection(url, user, password);
			query = "update emp set deptno=?";
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
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
