package beta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class multiple {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	//get Conn ===================================================================
	public void getConn() {
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_23K_AI17_p1_3"; //DB연결 계정
			String pass = "smhrd3"; //DB연결 비밀번호
			
			conn = DriverManager.getConnection(url, user, pass);
			
//			if(conn != null) {
//				System.out.println("연결성공");
//			} else {
//				System.out.println("연결실패");
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//close =======================================================================
	public void close() {
		
		try {
		if(rs != null) {rs.close();}
		if(psmt != null) {psmt.close();}
		if(conn != null) {conn.close();}
	} catch (SQLException e) {
		e.printStackTrace();
	}
//		System.out.println("연결종료");
		
	}
	// 배율 가져오기
	public int mulCheck (String word) {
		
		int multiple = 0;
		try {
			getConn();
			
			String sql2 = "select multiple from question where word=?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, word);
			rs = psmt.executeQuery();
			if(rs.next()) {
				multiple = rs.getInt(1);
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
				
			}
		return multiple;
		
	}
	
	// 배율 적용
	public int mulPlus (int money, int mul, String id) {
		
		int point = 0;
		int pointPlus = 0;
		int point2 = 0;
		
		try {
			getConn();
			
			String sql2 = "select point from userlist WHERE ID = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				point = rs.getInt(1);
			}
			
			String sql3 = "update userlist set point = ? where id = ?";
			psmt = conn.prepareStatement(sql3);
			pointPlus = money*mul;
			psmt.setInt(1, point+pointPlus);
			psmt.setString(2, id);
		
			psmt.executeUpdate();	
			point2 = point+pointPlus;
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
				
			}
		return point2;
		
	}
	
	// 배팅금액 증발
		public int mulMin (int money, String id) {
			
			int point = 0;
			int point2 = 0;
			
			try {
				getConn();
				
				String sql2 = "select point from userlist WHERE ID = ?";
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					point = rs.getInt(1);
				}
				
				String sql3 = "update userlist set point = ? where id = ?";
				psmt = conn.prepareStatement(sql3);
				point2 = point-money;
				psmt.setInt(1, point2);
				psmt.setString(2, id);
			
				psmt.executeUpdate();	
				
				
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
					
				}
			return point2;
			
		}
		
		// 현재금액 확인
		public int have(String id) {
			
			int point = 0;
			try {
				getConn();
				
				String sql2 = "select point from userlist WHERE ID = ?";
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					point = rs.getInt(1);
				}
						
				
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
					
				}
			return point;
			
		}
	
	

}
