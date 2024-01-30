package beta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class pet기능 {
	
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
	
	//펫 정보 추가========================================================================================
			public int petJoin(PetDTO dto) {
				
				int cnt = 0;
				
				try {
					getConn();
					
					String sql = "INSERT INTO pet VALUES (?, ?, ?)";
					
					psmt = conn.prepareStatement(sql);
					
					psmt.setString(1, dto.getID());
					psmt.setInt(2, dto.getPet_number());
					psmt.setString(3, dto.getPet_name());
					
					cnt = psmt.executeUpdate();
					
					
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return cnt;
				}
			
	// 펫 불러오기
			public ArrayList<PetDTO> petImformation(String id) {
				
				ArrayList<PetDTO> list = new ArrayList<>();
				
				try {
					getConn();
					
					String sql = "SELECT PET_NAME, PET_NUMBER FROM PET WHERE ID =? order by pet_number";
					
					psmt = conn.prepareStatement(sql);
					
					psmt.setString(1, id);
					
					rs = psmt.executeQuery();
					
					while (rs.next()) {
						String name = rs.getString(1);
						int number = rs.getInt(2);
						
						PetDTO dto = new PetDTO();
						dto.setPet_name(name);
						dto.setPet_number(number);
						
						list.add(dto);
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return list;
				}	
			
			public String petImage(int number) {
				String Image=null;
				if (number==2) {
				Image =	""
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠊⠠⠀⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠁⡈⠀⠂⡀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢰⠦⢨⡶⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠁⡘⢋⣀⠛⠀⠸⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡀⠄⠸⠤⠃⡨⢊⠡⡉⠑⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠠⡀⡥⡒⡃⢚⠲⢄⢢⡕⣄⠢⢨⠂⡔⠱⡡⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢸⠀⢌⠨⡈⡌⢌⢾⠀⡂⢍⠢⡌⡈⠂⡇⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠸⠐⠄⢂⡎⠐⢄⠈⡆⠐⠸⡀⠸⡄⢱⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⢣⠁⡇⠸⡐⠄⢌⠘⡌⢂⠱⡀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠓⠁⠀⠙⡔⠠⢂⠘⠦⡐⠱⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢢⡡⢈⠄⡉⠢⢍⣒⡆⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣸⣈⠁⢲⠚⠒⠉⠁⠁⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⠛⠟⠘⠛⠃";
				}else if (number ==1) {
					Image = "⠄⣠⣀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢈⣤⣥⠀\r\n"
							+ "⠀⠿⣽⣄⡂⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⣐⣤⡼⡗⠙⠀\r\n"
							+ "⠀⠀⢺⡮⡻⢷⢶⣤⣂⠀⢀⠀⠀⠀⠀⠀⠀⠀⢀⠀⢂⣤⡴⣾⢫⡞⣮⡇⠀⠀\r\n"
							+ "⠀⠀⢸⡯⣫⡳⡳⡵⣫⢟⣶⡄⠠⠀⠄⠠⠀⠄⠀⣾⡫⣗⢽⡪⣗⢽⣪⠇⠀⠀\r\n"
							+ "⠀⠀⠘⣯⢮⣫⡻⣜⢗⣽⢮⢗⣟⢟⡟⡿⣻⢻⢗⢿⢵⣫⢞⡵⣫⢮⣻⠀⠀\r\n"
							+ "⠀⠀⠀⣿⢮⡺⣜⡷⣫⢗⣝⢧⣫⢞⠝⠞⣵⢫⣏⢷⢭⡫⡷⣝⢮⡳⡯⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠻⠮⣗⢯⡺⣕⢯⡺⣕⡗⢠⠃⡌⣄⠹⣎⢷⡹⣎⢷⡹⣗⠛⠁⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢀⣿⡱⣏⢾⡱⣏⢾⣥⣛⠡⣂⢙⡼⣣⣟⢼⡣⣟⣜⢟⡆⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢸⣇⢿⡸⣧⢛⠉⡀⠈⠙⠳⠞⠊⠉⢀⠈⠳⣝⢮⢮⣫⡇⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⣿⢪⢷⠁⢘⣿⣶⠀⠀⠀⠀⠀⠀⢰⣿⡏⠈⣷⢳⣝⠃⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠘⢯⣻⡀⠀⠛⠀⠀⠀⢱⡪⠀⠄⠈⠋⠃⢀⣿⡵⠃⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢀⠀⡀⠙⢳⣬⣄⣂⣀⠀⠑⠚⢃⢀⣀⣀⣥⠞⠃⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠠⢠⠖⡿⢫⠮⢯⣝⣝⢟⣿⡻⣟⢯⣫⠽⢝⡷⡞⣦⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠠⠀⡉⠀⣯⠀⣏⠾⡊⠋⠀⠈⠑⡫⢧⢹⠀⣗⠈⡁⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⢧⣠⡏⠊⢀⠈⠀⠀⢀⠉⠊⢸⣄⠼⢲⡶⣻⠂⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡗⠀⠀⠀⢂⡠⠀⠀⠁⢺⣤⢶⣻⠎⠛⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠂⣚⠁⠈⠀⠀⣸⡇⠀⠀⠀⠉⣣⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠚⠒⠋⠁⠈⠓⠚⠒⠚⠁⠀⠀⠀⠀⠀";
				}else if (number ==3) {
					Image = ""
							+ "    ⢀⠦⠒⠦⣄⠀⠀⡰⠒⠒⢦⡀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢞⠀⢤⢀⠈⢦⠈⡇⢐⠤⡀⠱⡄⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠸⡀⠱⡈⠆⢸⠀⢧⠐⡅⢪⠀⡇⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢀⡽⠀⠁⠁⠈⠉⠉⠀⠈⠀⠀⣇⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⡰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⡀⠀⠀⠀\r\n"
							+ "⠀⠀⢰⠃⠀⠀⢀⠀⣦⡄⢀⠀⢰⣦⢀⠀⠀⠀⢱⡀⠀⠀\r\n"
							+ "⠀⠀⢕⠀⠀⠀⠀⠁⠉⠠⢌⡴⠀⠁⠀⠁⠀⠀⠀⡇⠀⠀\r\n"
							+ "⠀⠀⠸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠃⠀⠀\r\n"
							+ "⠀⠀⠀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠴⠃⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⡸⠓⡶⠤⡤⠤⠤⡤⠴⡖⠺⡁⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢰⠃⣰⠛⠛⠟⠒⠚⠝⠻⠓⣄⢹⠄⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠈⣳⠁⢌⠈⡂⠡⠑⡈⢂⠡⠈⢯⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠳⢴⠒⠬⢒⢵⡘⡢⠒⠵⡣⠚⠁⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠘⠢⠒⠃⠀⠀⠘⠢⠒⠁⠀⠀⠀⠀⠀";
				}else if (number ==4) {
					Image = ""
							+ "      ⡜⠉⠳⠀⡀⢰⠊⠑⡆⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⢀⠇⠀⠀⠉⠉⠁⠀⠀⢨⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠸⠀⢀⠃⡀⡀⡀⠃⠀⠈⡆⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢀⠯⠀⡊⠋⡘⠬⠮⢋⠄⠀⠸⡀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⡎⡂⠀⠱⠌⠀⠀⢀⠞⠀⠀⠀⢱⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢘⠀⡇⠀⠘⡀⠀⠀⡘⠀⠀⢀⠀⢀⠃⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠑⡇⠀⠀⠉⠒⠊⠁⠀⠀⠀⢑⠉⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⢦⠀⠀⠀⡀⡀⡀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠰⡀⢀⠀⡍⠈⠸⡀⠀⠠⡅⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠈⠁⠉⠀⠀⠀⠉⠉⠈⠀⠀";
				}else if (number ==5) {
					Image = "⢀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⢠⠔⠋⠀⠀⠈⠉⠲⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢠⠃⡴⢢⡄⠀⣾⣭⢱⠘⡆⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢸⠘⣄⢛⠇⠀⠓⠔⠊⠀⠱⡄⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢸⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠙⢤⡀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠈⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠸⡀⠀⠀⠀⠀⠀⠀⠀⢰⠢⠒⠁⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠹⢄⡀⢀⡼⠤⡠⠤⠋⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀";
				}
				return Image;
			}
			public int petCheck(String id,String name) {
				int add = 0;
				try {
				getConn();
				
				String sql = "SELECT * FROM PET WHERE ID = ? and pet_name = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, name);
							
				rs=psmt.executeQuery();
				if(rs.next()) {
					add= 1;
				}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return add;
			}
}
