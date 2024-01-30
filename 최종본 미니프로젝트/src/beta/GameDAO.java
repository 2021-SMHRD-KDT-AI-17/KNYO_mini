package beta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GameDAO {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	// 공통적으로 작성하고 있는 코드를 메서드로 분리 (수정하기 편하다)

//================================================================================
//                            반복되는 코드 분리 [연결]
//================================================================================
	public void getConn() {
		try {
			// [Java 프로그램과 데이터베이스를 연결하는 과정]
			// 1. JDBC 드라이버 동적 로딩
			// - Java 프로그램이 실행될 때 JDBC드라이버를 불러오는 과정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_23k_AI17_p1_3"; // DB연결 계정
			String password = "smhrd3"; // DB연결 비밀번호

			// 2. 데이터베이스 연결
			// - url, user, password정보를 전달
			// - 성공적으로 연결이 된 경우 Connection객체를 반환
			// - Connection객체 : DB연결, 종료, SQL실행 등의 기능을 제공하는 객체
			conn = DriverManager.getConnection(url, user, password);

			// 연결확인
//			if (conn != null) {
//				System.out.println("DB연결 성공!");
//			} else {
//				System.out.println("DB연결 실패...T^T");
//			}

		} catch (Exception e) {
			e.printStackTrace(); // 오류 출력
		}
	}

//================================================================================
//                            반복되는 코드 분리 [종료]
//================================================================================

	public void close() {

		// 4. 데이터베이스 연결 종료(연결된 객체의 역순으로 종료)
		// - 데이터베이스 관련 작업이 끝난 경우 연결되어 있는 모든 객체는 반드시 종료를 해줘야 한다!!
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("DB연결종료!");

	}

//-------------------------------------------------------------------------------------------------
	
	
	

// ================================================================================
// 									문제 불러오기
	
//==================================과일=========================================

	public ArrayList<ThemaDTO> fruitQZ() {

		ArrayList<ThemaDTO> list = new ArrayList<>();
		
		
		try {
			getConn();
			
			String sql = "SELECT word, multiple, hint, hint2 FROM question WHERE thema = 'fruit'";
			psmt = conn.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String word = rs.getString(1);
				double multiple = rs.getDouble(2);
				String hint = rs.getString(3);
				String hint2 = rs.getString(4);

				ThemaDTO result = new ThemaDTO();
				
				result.setFruit(word);
				result.setMultiple(multiple);
				result.setHint(hint);
				result.setHint2(hint2);
				
				list.add(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	
	
//==================================동물=========================================

	public ArrayList<ThemaDTO> animalQZ() {

		ArrayList<ThemaDTO> list = new ArrayList<>();
		
		
		try {
			getConn();

			String sql = "SELECT word, multiple, hint, hint2 FROM question WHERE thema = 'animal'";
			psmt = conn.prepareStatement(sql);


			rs = psmt.executeQuery();

			while (rs.next()) {
				String animal = rs.getString(1);
				double multiple = rs.getDouble(2);
				String hint = rs.getString(3);
				String hint2 = rs.getString(4);

				ThemaDTO result = new ThemaDTO();
				
				result.setAnimal(animal);
				result.setMultiple(multiple);
				result.setHint(hint);
				result.setHint2(hint2);
				
				list.add(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
//==================================스포츠=========================================

	public ArrayList<ThemaDTO> sportQZ() {

		ArrayList<ThemaDTO> list = new ArrayList<>();
		
		
		try {
			getConn();

			String sql = "SELECT word, multiple, hint, hint2 FROM question WHERE thema = 'sport'";
			psmt = conn.prepareStatement(sql);


			rs = psmt.executeQuery();

			while (rs.next()) {
				String sport = rs.getString(1);
				double multiple = rs.getDouble(2);
				String hint = rs.getString(3);
				String hint2 = rs.getString(4);

				ThemaDTO result = new ThemaDTO();
				
				result.setSport(sport);
				result.setMultiple(multiple);
				result.setHint(hint);
				result.setHint2(hint2);
				
				list.add(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
				
//==================================수도=========================================

	public ArrayList<ThemaDTO> countryQZ() {

		ArrayList<ThemaDTO> list = new ArrayList<>();
		
		
		try {
			getConn();

			String sql = "SELECT word, multiple, hint FROM question WHERE thema = 'country'";
			psmt = conn.prepareStatement(sql);


			rs = psmt.executeQuery();

			while (rs.next()) {
				String country = rs.getString(1);
				double multiple = rs.getDouble(2);
				String hint = rs.getString(3);

				ThemaDTO result = new ThemaDTO();
				
				result.setCountry(country);
				result.setMultiple(multiple);
				result.setHint(hint);
				
				list.add(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
				
//==================================직업=========================================

	public ArrayList<ThemaDTO> jobQZ() {

		ArrayList<ThemaDTO> list = new ArrayList<>();
		
		
		try {
			getConn();

			String sql = "SELECT word, multiple, hint, hint2 FROM question WHERE thema = 'job'";
			psmt = conn.prepareStatement(sql);


			rs = psmt.executeQuery();

			while (rs.next()) {
				String job = rs.getString(1);
				double multiple = rs.getDouble(2);
				String hint = rs.getString(3);
				String hint2 = rs.getString(4);

				ThemaDTO result = new ThemaDTO();
				
				result.setJob(job);
				result.setMultiple(multiple);
				result.setHint(hint);
				result.setHint2(hint2);
				
				list.add(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	
	

}
