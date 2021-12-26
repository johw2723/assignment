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
		FulseCase b = new FulseCase();

		// 로직 시작
		int true_value = a.transform(); // int true_value : 100  
		dao.update_emp(true_value); // 실행 및 종료 - TB_EMP : DEPTNO 컬럼 값 : 100으로 변경
		dao.update_dept(true_value); // 실행 및 종료 - TB_DEPT : DEPTNO 컬럼 값 : 100으로 변경
		
		int false_value = b.transform(); // NumberFormatException
		dao.update_emp(false_value); // 실행 및 종료 - TB_EMP : DEPTNO 컬럼 값 : 0으로 변경 
		dao.update_dept(false_value); // 실행 및 종료 - TB_DEPT : DEPTNO 컬럼 값 : 0으로 변경
		// why 0 ? = transform()에서 int value를 0으로 초기화되어있었기 때문에 Integer.parseInt(str) 값으로 변경되는 것이 미실행되었어도 기존 초기화 값 0이 리턴되었다.
		
	}
	
	// emp 테이블 TEST 칼럼 값 변경
	public void update_emp(int num) {
		System.out.println("update_emp 실행");
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
				System.out.println("update_emp 종료");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// dept 테이블 TEST 칼럼 값 변경
	public void update_dept(int num) {
		System.out.println("update_dept 실행");
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
				System.out.println("update_dept 종료");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
