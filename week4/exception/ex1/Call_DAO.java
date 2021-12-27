package week4.exception.ex1;

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
				
		Call_DAO dao = new Call_DAO();
		
		// 객체생성
		Push_TB_EMP emp = new Push_TB_EMP();
		Push_TB_DEPT dept = new Push_TB_DEPT();

		/* exception ex1 로직 시작 (예외처리를 메소드에서 개별 처리할 경우)
		 * TB_EMP - DEPTNO 컬럼 타입 : VARCHAR 
		 * TB_DEPT - DEPTNO 컬럼 타입 : NUMBER
		 */
		String str1 = emp.str; 
		String str2 = dept.str;
		dao.update_emp(str1); // String 값을 VARCHAR 타입 칼럼에 넣을 경우 (true)
		dao.update_dept(str2); // String 값을 NUMBER 타입 칼럼에 넣을 경우 (false)
		
		// 결과
		// dao.update_emp(str1) 정상 실행 -> TB_EMP DEPTNO 값 입력 성공 - true
		// dao.update_dept(str2) 에러 발생 -> TB_DEPT DEPTNO 값 입력 실패 - NULL
		
	}
	
	// EMP 테이블 DEPTNO 칼럼 값 변경 (VARCHAR 타입)
	public void update_emp(String str) {
		System.out.println("update_emp 실행");
		try{
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			query = "UPDATE TB_EMP SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, str);
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
			System.out.println("update_emp 종료");
		}
	}
	
	// DEPT 테이블 DEPTNO 칼럼 값 변경 (NUMBER 타입)
	public void update_dept(String str) {
		System.out.println("update_dept 실행");
		try{
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			query = "UPDATE TB_DEPT SET DEPTNO=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, str);
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
			System.out.println("update_dept 종료");
		}
	}
	
}
