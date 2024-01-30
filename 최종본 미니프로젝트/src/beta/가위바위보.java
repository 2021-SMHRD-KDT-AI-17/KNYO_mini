package beta;

import java.util.Scanner;

import javazoom.jl.player.MP3Player;

import java.util.ArrayList;
import java.util.Random;

public class 가위바위보 {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	shop s = new shop();
	
	public void game2(String id) {
		MP3Player mp3 = new MP3Player();
		Controller con = new Controller();
		ArrayList<Music> mL = new ArrayList<>();
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\MP\\";
		Scanner sc = new Scanner(System.in);

		Music win = new Music(defaultPath + "win.mp3");
		Music lose = new Music(defaultPath + "lose.mp3");
		mL.add(win);
		mL.add(lose);
		
		
		System.out.println("가위바위보 게임");

		while (true) {
			System.out.println("[1]게임시작 [2]종료");

			int choice = sc.nextInt();

			if (choice == 2) {
				break;
			} else {

				

				while(true) {
					int num1 = rd.nextInt(3) + 1;
					System.out.print("[1]가위 [2]바위 [3]보 >> ");
					int num2 = sc.nextInt();

					if (num1 == 1) {
						System.out.println("상대 : 가위");
					} else if (num1 == 2) {
						System.out.println("상대 : 바위");
					} else if (num1 == 3) {
						System.out.println("상대 : 보");
					}
					if (num2 == num1) {
						System.out.println("비겼습니다.");
						continue;
					} else if (num2 == 1 && num1 == 2) {
						con.musicPlay(1, mL);
						System.out.println("ㅠ.ㅠ 졌네요...");
						break;
					} else if (num2 == 1 && num1 == 3) {
						con.musicPlay(0, mL);
						System.out.println("이겼다~~~");
						s.ticketPlus(id);
						break;
					} else if (num2 == 2 && num1 == 3) {
						con.musicPlay(1, mL);
						System.out.println("ㅠ.ㅠ 졌네요...");
						break;
					} else if (num2 == 2 && num1 == 1) {
						con.musicPlay(0, mL);
						System.out.println("이겼다~~~");
						s.ticketPlus(id);
						break;
					} else if (num2 == 3 && num1 == 1) {
						con.musicPlay(1, mL);
						System.out.println("ㅠ.ㅠ 졌네요...");
						break;
					} else if (num2 == 3 && num1 == 2) {
						con.musicPlay(0, mL);
						System.out.println("이겼다~~~");
						s.ticketPlus(id);
						break;
					}
				}
				
			}
		}

	}

}
