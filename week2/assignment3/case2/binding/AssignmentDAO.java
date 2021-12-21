package week2.assignment3.case2.binding;

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
		
		int resultA = a.divide(50, 0); // ArithmeticException 에러
		dao.update_emp(resultA); // TEST 칼럼 (VARCAHR) - 0 값 입력됨
		dao.update_dept(resultA);   // TEST 칼럼 NUMBER - 0 값 입력됨
		
		// 종료되지 않고 실행
		int resultB = b.divide(50, 1); 
		dao.update_emp(resultB); // TEST 칼럼 (VARCAHR) - 50 값 입력됨
		dao.update_dept(resultB);	// TEST 칼럼 NUMBER - 50 값 입력됨	
	}
	
	// emp 테이블 TEST 칼럼 값 변경
		public void update_emp(int num) {
			System.out.println("emp 테이블 TEST 칼럼 값 변경");
			try{
				con = DriverManager.getConnection(url, user, password);
				query = "update emp set test=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, String.valueOf(num));
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
				pstmt.setString(1, String.valueOf(num));
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
