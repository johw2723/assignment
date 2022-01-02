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
			System.out.println("드라이버 호출 에러");
		}
	}
	
	public static Call_DAO getInstance() {
		return instance;
	}
	
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
		
		// 객체생성
		Call_DAO dao = new Call_DAO();
		Push_TB_EMP emp = new Push_TB_EMP();
		Push_TB_DEPT dept = new Push_TB_DEPT();

		/* exception ex_throws 로직 시작 (예외처리를 호출 받는 곳에서 개별적으로 할 경우)
		 * TB_EMP - DEPTNO 컬럼 타입 : VARCHAR 
		 * TB_DEPT - DEPTNO 컬럼 타입 : NUMBER
		 */
		
		//dao.update_emp(emp.str); // str = "백" - 컴파일 에러 : change 메서드로 인해서 int 값을 받기 때문
		dao.update_emp(emp.change(emp.str)); // str = "백" NumberFormatException 예외 발생 
		//dao.update_dept(dept.str); // str = "100" - 컴파일 에러 : change 메서드로 인해서 int 값을 받기 때문
		dao.update_dept(dept.change(dept.str)); // str = "100" NumberFormatException 예외 미발생
			
		// 결과
		// dao.update_emp() 에러 발생 -> TB_EMP DEPTNO 값 변화 NULL -> 0 (return 값으로 설정한 변수의 초기값)
		// 여기서 테이블 TB_EMP의 DEPTNO 컬럼의 타입이 VARCHAR 타입인데 int값을 받고도 갑 입력이 된 걸 확인할 수 있다.
		
		// dao.update_dept() 정상 실행 -> TB_DEPT DEPTNO 값 변화 NULL -> 100
	}
	
	// EMP 테이블 DEPTNO 칼럼(VARCHAR 타입) 값 변경 
	public void update_emp(int value) {
		System.out.println("update_emp 실행");
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
			System.out.println("update_emp 종료");
		}
	}
	
	// DEPT 테이블 DEPTNO 칼럼(NUMBER 타입) 값 변경 
	public void update_dept(int value) {
		System.out.println("update_dept 실행");
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
			System.out.println("update_dept 종료");
		}
	}
	
}
