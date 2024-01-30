package beta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class shop {
	
	Random rd = new Random();
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
			
			if(conn != null) {
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");
			}
			
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
		System.out.println("연결종료");
		
	}
	
	
	// 배팅포인트 보호권 추가(상점 기능)
	public int protectPlus (String id) {
		
		int cnt = 0;
		int protect = 0;
		try {
			getConn();
			
			String sql2 = "select protect from userlist WHERE ID = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				protect = rs.getInt(1);
			}
					
			String sql = "UPDATE userlist SET protect=? WHERE ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, protect+1);
			psmt.setString(2, id);

			cnt = psmt.executeUpdate();
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
				
			}
		return cnt;
		
	}
	
	// 배율 증가권 추가(상점)
	public int multiplePlus (String id) {
		
		int cnt = 0;
		int multiple_plus = 0;
		try {
			getConn();
			
			String sql2 = "select multiple_plus from userlist WHERE ID = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				multiple_plus = rs.getInt(1);
			}
					
			String sql = "UPDATE userlist SET multiple_plus=? WHERE ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, multiple_plus+1);
			psmt.setString(2, id);

			cnt = psmt.executeUpdate();
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
				
			}
		return cnt;
		
	}
	
	// 펫뽑기권 추가 (상점)
	
public int petPlus (String id) {
		
		int cnt = 0;
		int petPlus = 0;
		try {
			getConn();
			
			String sql2 = "select pet_ticket from userlist WHERE ID = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				petPlus = rs.getInt(1);
			}
					
			String sql = "UPDATE userlist SET pet_ticket=? WHERE ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, petPlus+1);
			psmt.setString(2, id);

			cnt = psmt.executeUpdate();
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
				
			}
		return cnt;
		
	}

	// 10만 포인트 추가
public int pointPlus (String id) {
	
	int cnt = 0;
	int pointplus = 0;
	try {
		getConn();
		
		String sql2 = "select point from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			pointplus = rs.getInt(1);
		}
				
		String sql = "UPDATE userlist SET point=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, pointplus+100000);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}
// 5만포인트 증가
public int pointPlus2 (String id) {

int cnt = 0;
int pointplus = 0;
try {
	getConn();
	
	String sql2 = "select point from userlist WHERE ID = ?";
	psmt = conn.prepareStatement(sql2);
	psmt.setString(1, id);
	rs = psmt.executeQuery();
	if(rs.next()) {
		pointplus = rs.getInt(1);
	}
			
	String sql = "UPDATE userlist SET point=? WHERE ID = ?";
	psmt = conn.prepareStatement(sql);
	psmt.setInt(1, pointplus+50000);
	psmt.setString(2, id);

	cnt = psmt.executeUpdate();
	
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close();
		
	}
return cnt;

}
// 금액차감(상점 이용)
public int pointMinus (String id) {
	
	int cnt = 0;
	int pointMinus = 0;
	try {
		getConn();
		
		String sql2 = "select point from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			pointMinus = rs.getInt(1);
		}
				
		String sql = "UPDATE userlist SET point=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, pointMinus-10000);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}

// pet뽑기권 보유 현황 보기
public int petchekct (String id) {
	
	int petcheck = 0;
	try {
		getConn();
		
		String sql2 = "select pet_ticket from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			petcheck = rs.getInt(1);
		}
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return petcheck;
	
}

//pet 마리수 확인
public int petcheck (String id) {
	
	int petcheck = 0;
	try {
		getConn();
		
		String sql2 = "select count(pet_name) from pet WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			petcheck = rs.getInt(1);
		}
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return petcheck;
	
}

//protect 보유 현황 보기
public int protectCheck (String id) {
	
	int protect = 0;
	try {
		getConn();
		
		String sql2 = "select protect from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			protect = rs.getInt(1);
		}
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return protect;
	
}
// protect 사용
public int protectUse (String id) {
	
	int cnt = 0;
	int protect = 0;
	try {
		getConn();
		
		String sql2 = "select protect from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			protect = rs.getInt(1);
		}
				
		String sql = "UPDATE userlist SET protect=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, protect-1);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}

//plus 보유 현황 보기
public int multPlus (String id) {
	
	int multPlus = 0;
	try {
		getConn();
		
		String sql2 = "select multiple_plus from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			multPlus = rs.getInt(1);
		}
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return multPlus;
	
}

//plus 사용
public int multPlusUse (String id) {
	
	int cnt = 0;
	int multPlus = 0;
	try {
		getConn();
		
		String sql2 = "select multiple_plus from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			multPlus = rs.getInt(1);
		}
				
		String sql = "UPDATE multiple_plus SET multiple_plus=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, multPlus-1);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}

//pet뽑기
public int petMinus (String id) {
	
	int cnt = 0;
	int petMinus = 0;
	try {
		getConn();
		
		String sql2 = "select pet_ticket from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			petMinus = rs.getInt(1);
		}	
		String sql = "UPDATE userlist SET pet_ticket=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, petMinus-1);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}
// 회원 아이디 불러오기

public String checkID (String id) {
	
	String ID = null;
	try {
		getConn();
		
		String sql2 = "select ID from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			ID = rs.getString(1);
		}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return ID;
	
}

// 가위바위보 티켓 보유 현황
public int ticketcheck(String id) {
	
	int ticketcheck = 0;
	try {
		getConn();
		
		String sql2 = "select shop_ticket from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			ticketcheck = rs.getInt(1);
		}
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return ticketcheck;
	
}

// 가위바위보 상점 티켓차감
public int ticketMinus (String id) {
	
	int cnt = 0;
	int ticketMinus = 0;
	try {
		getConn();
		
		String sql2 = "select shop_ticket from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			ticketMinus = rs.getInt(1);
		}
				
		String sql = "UPDATE userlist SET shop_ticket=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, ticketMinus-1);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}

//가위바위보 상점 티켓추가
public int ticketPlus (String id) {
	
	int cnt = 0;
	int ticketPlus = 0;
	try {
		getConn();
		
		String sql2 = "select shop_ticket from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			ticketPlus = rs.getInt(1);
		}
				
		String sql = "UPDATE userlist SET shop_ticket=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, ticketPlus+1);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}

public int pcPoint (String id) {
	
	int cnt = 0;
	int pointplus = 0;
	try {
		getConn();
		
		String sql2 = "select point from userlist WHERE ID = ?";
		psmt = conn.prepareStatement(sql2);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if(rs.next()) {
			pointplus = rs.getInt(1);
		}
				
		String sql = "UPDATE userlist SET point=? WHERE ID = ?";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, pointplus+200000);
		psmt.setString(2, id);

		cnt = psmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
	return cnt;
	
}



}


