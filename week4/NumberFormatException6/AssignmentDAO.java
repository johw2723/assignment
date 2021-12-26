package week4.NumberFormatException6;

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
		
		TrueCase a = new TrueCase();

		/* 로직 시작
		 * TB_EMP - DEPTNO 컬럼 타입 : VARCHAR 
		 * TB_DEPT - DEPTNO 컬럼 타입 : NUMBER
		 */
		try {
			String str_value = a.str; // String str_value : "100A" 
			dao.update_emp(str_value); // String 값을 VARCHAR 타입 칼럼에 넣을 경우 (true)
			dao.update_dept(str_value); // String 값을 NUMBER 타입 칼럼에 넣을 경우 (false)
		} catch(SQLException e) {
			e.printStackTrace();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// emp 테이블 TEST 칼럼 값 변경
		public void update_emp(String str) throws SQLException {
			System.out.println("update_emp 실행");

			con = DriverManager.getConnection(url, user, password);
			query = "UPDATE TB_EMP SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, str);
			pstmt.executeUpdate();
				
			pstmt.close();			
			con.close();
			System.out.println("update_emp 종료");

		}
	
	// dept 테이블 TEST 칼럼 값 변경
		public void update_dept(String str) throws SQLException {
			System.out.println("update_dept 실행");
			
			con = DriverManager.getConnection(url, user, password);
			query = "UPDATE TB_DEPT SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, str);
			pstmt.executeUpdate();
			
			pstmt.close();			
			con.close();
			System.out.println("update_dept 종료");
		
		}
	
}
