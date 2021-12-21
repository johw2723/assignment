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
		
		A a = new A();
		B b = new B();

		try{
			int resultA = a.divide(50, 0); // 오류
			dao.update_emp(resultA); // 멈춤 null
			dao.update_dept(resultA); // 멈춤 null
			
			// 멈춤
			int resultB = b.divide(50, 1);
			dao.update_emp(resultB);
			dao.update_dept(resultB);
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}		
	}
	
	// emp 테이블 TEST 칼럼 값 변경
	public void update_emp(int num) {
		System.out.println("emp 테이블 TEST 칼럼 값 변경");
		try{
			con = DriverManager.getConnection(url, user, password);
			query = "update emp set test=?";
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
	
	// dept 테이블 TEST 칼럼 값 변경
	public void update_dept(int num) {
		System.out.println("dept 테이블 TEST 칼럼 값 변경");
		try{
			con = DriverManager.getConnection(url, user, password);
			query = "update dept set test=?";
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
