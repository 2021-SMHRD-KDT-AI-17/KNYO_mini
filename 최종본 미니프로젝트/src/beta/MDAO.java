package beta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MDAO {

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
////				System.out.println("연결성공");
//			} else {
////				System.out.println("연결실패");
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
	
	
	//로그인=======================================================================
	public MDTO login(MDTO dto) {
		
		MDTO result = null;
		
		try {
			getConn();
			
			String sql = "select * from USERLIST where ID=? and PW=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getID());
			psmt.setString(2, dto.getPW());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = new MDTO();
				String getID = rs.getString(1);
				String getPW = rs.getString(2);
				String getNICK = rs.getString(3);
				
				result.setID(getID);
				result.setPW(getPW);
				result.setNICK(getNICK);
				
				System.out.println("꒰⚘݄꒱₊_______________\r\n"
						+ "\t"+getNICK+"님 안녕하세요!\r\n"
						+ "");
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	
	//로그인-현재 보유 포인트==========================================
	public void have(MDTO dto) {
		
		try {
			getConn();
		
			String sql = "select NICK, POINT from USERLIST where ID=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getID());
		
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			
			String getNICK = rs.getString(1);
			int getPOINT = rs.getInt(2);
			if(getPOINT>=10000000) {
				System.out.print("<🏆> ");
			}else if (getPOINT>=1000000) {
				System.out.print("<💎> ");
			}else if (getPOINT>=100000) {
				System.out.print("<⛏> ");
			}else {
				System.out.print("<💀> ");
			}
			
			System.out.println(getNICK+"님의 현재 보유포인트는 "+getPOINT+"p입니다.");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	//현재 보유 포인트 체크==========================================
		public int pointCheck(MDTO dto) {
			
			int point = 0;
			
			try {
				getConn();
				
				String sql = "select NICK, POINT from USERLIST where ID=?";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getID());
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					
					String getNICK = rs.getString(1);
					int getPOINT = rs.getInt(2);
					
					point = getPOINT;
					
			}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return point;
			}
		
		//로그인-랭킹출력============================================================
		public ArrayList<MDTO> rank() {
			ArrayList<MDTO> list = new ArrayList<MDTO>();
			
			try {
				getConn();
				
				String sql = "select  ID, NICK, POINT from userlist where rownum <= 5 order by point desc";
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					MDTO dto = new MDTO();
					dto.setID(rs.getString(1));
					dto.setNICK(rs.getString(2));
					dto.setPOINT(rs.getInt(3));
					
					list.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
		}
		
		
		//회원가입========================================================================================
		public int join(MDTO dto) {
			
			int cnt = 0;
			
			try {
				getConn();
				
				String sql = "INSERT INTO USERLIST(ID, PW, NICK,POINT) VALUES (?, ?, ?, ?)";
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, dto.getID());
				psmt.setString(2, dto.getPW());
				psmt.setString(3, dto.getNICK());
				psmt.setInt(4,10000);
				
				cnt = psmt.executeUpdate();
				
				if(cnt>0) {
					System.out.println("회원가입 성공!");
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return cnt;
			}
		
		//미중복 id================================================================================
		public int idCheck(String id) {
			try {
			getConn();
			
			String sql = "SELECT * FROM Userlist WHERE ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
						
			rs=psmt.executeQuery();
			if(rs.next()) {
				return 1;//중복된 id
			}else {
				
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return 0;
		}
		

		//1만 포인트 미만시=====================================================
				public int LP(MDTO dto) {
					
					int cnt = 0;
					
					try {
						getConn();
						
						String sql = "select NICK, POINT from USERLIST where ID=?";
						
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, dto.getID());
						
						rs = psmt.executeQuery();
						
						while(rs.next()) {
							
							String getNICK = rs.getString(1);
							int getPOINT = rs.getInt(2);
							
							cnt = getPOINT;
							
					}
						
					}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						close();
					}
					return cnt;
					}
				
				public void low(MDTO dto) {
					
					try {
						getConn();
						
						String sql = "select NICK, POINT from USERLIST where ID=?";
						
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, dto.getID());
						
						rs = psmt.executeQuery();
						
						while(rs.next()) {
							
							String getNICK = rs.getString(1);
							int getPOINT = rs.getInt(2);
							
							System.out.println(10000-getPOINT+"p가 부족합니다!");
					} 
					}catch (Exception e) {
						e.printStackTrace();
					} finally {
						close();
					}
				}
		
		


		
		
		
		
		
		
	


	
	
	
	
	
	
	
	
	
	
	
}
