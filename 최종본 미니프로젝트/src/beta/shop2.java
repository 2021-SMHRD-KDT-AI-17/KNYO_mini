package beta;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class shop2 {

	Scanner sc= new Scanner(System.in);
	Random rd = new Random();
	shop s = new shop();
	PetDTO dto = new PetDTO();
	pet기능 pett = new pet기능();
	String defaultPath = "C:\\Users\\SMHRD\\Desktop\\MP\\";
	
	ArrayList<Music> mL = new ArrayList<>();
	Controller con = new Controller();
	MP3Player mp3 = new MP3Player();
	Music ggwang = new Music(defaultPath + "ggwang.mp3");
	Music dang = new Music(defaultPath + "dang.mp3");
	Music pet1 = new Music(defaultPath + "pet.mp3");
	// 일반상점
	
	public void gacha(String name) {
		mL.add(ggwang);
		mL.add(dang);
		
			
		s.pointMinus(name);
			int num = rd.nextInt(50);
			if(num>=50) {
				con.musicPlay(1, mL);
			System.out.println("축하드립니다. 펫 뽑기 티켓 당첨!!!");
			s.petPlus(name);
		}else if(num>=40) {
			con.musicPlay(1, mL);
			System.out.println("축하드립니다. [̲̅₩̲̅(̲̅1̲̅0̲̅0̲̅0̲̅0̲̅0̲̅)̲̅₩̲̅]p 당첨!!!");
			s.pointPlus(name);
		}else if(num>=30) {
			con.musicPlay(1, mL);
			System.out.println("축하드립니다. 배팅포인트 보호티켓 당첨!!!");
			s.protectPlus(name);
		}else if(num>=25) {
			con.musicPlay(1, mL);
			System.out.println("축하드립니다. 배율추가티켓 당첨!!!");
			s.multiplePlus(name);
			
		}else if(num>=0) {
			System.out.println("＿人人人人人人＿\r\n"
					+ "＞　　꽝！ 　＜\r\n"
					+ "￣^Y^Y^Y^Y^￣\r\n"
					+ "");
			con.musicPlay(0, mL);
			
			
		}
			
			
		}
	
	// 가위바위보 상점
	// 
		public void gacha2(String name) {
			mL.add(ggwang);
			mL.add(dang);
				s.ticketMinus(name);
				int num = rd.nextInt(15);

				 if(num>=14) {
					 con.musicPlay(1, mL);
				System.out.println("축하드립니다. [̲̅₩̲̅(̲̅50̲̅0̲̅0̲̅0̲̅)̲̅₩̲̅]p 당첨!!!");
				s.pointPlus2(name);
			}else if(num>=12) {
				con.musicPlay(1, mL);
				System.out.println("축하드립니다. 배팅포인트 보호티켓 당첨!!!");
				s.protectPlus(name);
			}else if(num>=10) {
				con.musicPlay(1, mL);
				System.out.println("축하드립니다. 배율추가티켓 당첨!!!");
				s.multiplePlus(name);
			}else if(num>=0) {
				con.musicPlay(0, mL);
				System.out.println("＿人人人人人人＿\r\n"
						+ "＞　　꽝！ 　＜\r\n"
						+ "￣^Y^Y^Y^Y^￣\r\n"
						+ "");
			}
				
				
			}
	
//	================================== 펫
	
		public void petgacha(String pet ) {
			mL.add(pet1);
			
			
			
			String petN=null;
			int petNu=0;
			
			s.petMinus(pet);
			String id = s.checkID(pet);
		int num = rd.nextInt(5)+1;
		if(num==1) {
			con.musicPlay(0, mL);
			System.out.println("⠄⣠⣀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢈⣤⣥⠀\r\n"
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
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠚⠒⠋⠁⠈⠓⠚⠒⠚⠁⠀⠀⠀⠀⠀");
			System.out.println("     No.1 쿠로미");
			System.out.println("     축하드립니다!!!!");
			petN="쿠로미";
			petNu=1;
			dto.setID(id);
			dto.setPet_name(petN);
			dto.setPet_number(petNu);
			int joongbok = pett.petCheck(id, dto.getPet_name());
			

			

	        // 중복된 펫이 없을 경우
	        if (joongbok == 0) {
	            System.out.println("펫을 성공적으로 획득했습니다!");
	            // 새로운 펫을 등록하는 메소드 호출
	            pett.petJoin(dto);
	        } else {
	            System.out.println("이미 보유 중인 펫이므로 포인트 20만을 지급합니다.");
	            // 포인트를 지급하는 메소드 호출
	            s.pcPoint(id);
	        }
			
			
	}else if(num==2) {
		con.musicPlay(0, mL);
		System.out.println(""
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
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⠛⠟⠘⠛⠃");
		System.out.println("      No.2 바나나맨 ");
		System.out.println("      축하드립니다!!!!");
		dto.setID(id);
		petN="바나나맨";
		petNu=2;
		dto.setID(id);
		dto.setPet_name(petN);
		dto.setPet_number(petNu);
		int joongbok = pett.petCheck(id, dto.getPet_name());

		

	    // 중복된 펫이 없을 경우
	    if (joongbok == 0) {
	        System.out.println("펫을 성공적으로 획득했습니다!");
	        // 새로운 펫을 등록하는 메소드 호출
	        pett.petJoin(dto);
	    } else {
	        System.out.println("이미 보유 중인 펫이므로 포인트 20만을 지급합니다.");
	        // 포인트를 지급하는 메소드 호출
	        s.pcPoint(id);
	    }
	}else if(num==3) {
		con.musicPlay(0, mL);
		System.out.println(""
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
				+ "⠀⠀⠀⠀⠀⠀⠘⠢⠒⠃⠀⠀⠘⠢⠒⠁⠀⠀⠀⠀⠀");
		System.out.println("      No.3 토갱이");
		System.out.println("     축하드립니다!!!!");
		petN="토갱이";
		petNu=3;
		dto.setID(id);
		dto.setPet_name(petN);
		dto.setPet_number(petNu);
		int joongbok = pett.petCheck(id, dto.getPet_name());

		

	    // 중복된 펫이 없을 경우
	    if (joongbok == 0) {
	        System.out.println("펫을 성공적으로 획득했습니다!");
	        // 새로운 펫을 등록하는 메소드 호출
	        pett.petJoin(dto);
	    } else {
	        System.out.println("이미 보유 중인 펫이므로 포인트 20만을 지급합니다.");
	        // 포인트를 지급하는 메소드 호출
	        s.pcPoint(id);
	    }
	}else if(num==4) {
		con.musicPlay(0, mL);
		System.out.println(""
				+ "      ⡜⠉⠳⠀⡀⢰⠊⠑⡆⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢀⠇⠀⠀⠉⠉⠁⠀⠀⢨⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠸⠀⢀⠃⡀⡀⡀⠃⠀⠈⡆⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⢀⠯⠀⡊⠋⡘⠬⠮⢋⠄⠀⠸⡀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⡎⡂⠀⠱⠌⠀⠀⢀⠞⠀⠀⠀⢱⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⢘⠀⡇⠀⠘⡀⠀⠀⡘⠀⠀⢀⠀⢀⠃⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠑⡇⠀⠀⠉⠒⠊⠁⠀⠀⠀⢑⠉⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢦⠀⠀⠀⡀⡀⡀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠰⡀⢀⠀⡍⠈⠸⡀⠀⠠⡅⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠈⠁⠉⠀⠀⠀⠉⠉⠈⠀⠀");
		
		System.out.println("     No.4 낼름이");
		System.out.println("     축하드립니다!!!!");
		petN="낼름이";
		petNu=4;
		dto.setID(id);
		dto.setPet_name(petN);
		dto.setPet_number(petNu);
		int joongbok = pett.petCheck(id, dto.getPet_name());

		// 애완동물이 있을 경우
		if (joongbok > 0) {
		    System.out.println("보유중 - point 20만");
		    
		    // 포인트 적립 메소드 호출
		    s.pcPoint(id);
		} 
		// 애완동물이 없을 경우
		else {
		    // 애완동물 등록 메소드 호출
		    pett.petJoin(dto);
		}
	}else if(num==5) {
		con.musicPlay(0, mL);
		System.out.println("⢀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢠⠔⠋⠀⠀⠈⠉⠲⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⢠⠃⡴⢢⡄⠀⣾⣭⢱⠘⡆⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⢸⠘⣄⢛⠇⠀⠓⠔⠊⠀⠱⡄⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⢸⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠙⢤⡀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠈⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠸⡀⠀⠀⠀⠀⠀⠀⠀⢰⠢⠒⠁⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠹⢄⡀⢀⡼⠤⡠⠤⠋⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀");
		System.out.println("      No.5 가스트 ");
		System.out.println("      축하드립니다!!!! ");
		petN="가스트";
		petNu=5;
		dto.setID(id);
		dto.setPet_name(petN);
		dto.setPet_number(petNu);
		int joongbok = pett.petCheck(id, dto.getPet_name());

		// 애완동물이 있을 경우
		if (joongbok > 0) {
		    System.out.println("보유중 - point 20만");
		    
		    // 포인트 적립 메소드 호출
		    s.pcPoint(id);
		} 
		// 애완동물이 없을 경우
		else {
		    // 애완동물 등록 메소드 호출
		    pett.petJoin(dto);
		}
	}
		
		
		
		
	}
	}



