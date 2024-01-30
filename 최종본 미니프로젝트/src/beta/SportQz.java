package beta;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class SportQz {

	static Random rd = new Random();
	static GameDAO gdao = new GameDAO();
	Scanner sc = new Scanner(System.in);
	ThemaDTO thdto = new ThemaDTO();
	multiple mul = new multiple();
	shop shop = new shop();
	int pethave = 0;

	private static class TimerStart extends Thread {

		// 타이머 카운트다운
		public void run() {
			
			MP3Player mp3 = new MP3Player();
			Controller con = new Controller();
			ArrayList<Music> mL = new ArrayList<>();
			String defaultPath = "C:\\Users\\SMHRD\\Desktop\\MP\\";
			Music timer = new Music(defaultPath + "timer.mp3");
			Music lose = new Music(defaultPath + "lose.mp3");
			mL.add(timer);
			mL.add(lose);
			

			for (int i = 180; i >= 0; i--) {
				try {
					Thread.sleep(1000);
					if (i == 15) {
						System.out.println(i + "초 남았습니다.");
					}
					if (i <= 5) {
						con.musicPlay(0, mL);
						System.out.println(i);
					}

					if (i == 0) {
						con.musicPlay(1, mL);
						System.out.println("게임 종료!");
						System.exit(0);
						; // THread 종료.
					}
				} catch (InterruptedException e) {
					interrupt();
				}

			}

		}
	}

	// 게임 시작
	public void SportQ(TimerStart TS, String id) {
		MP3Player mp3 = new MP3Player();
		Controller con = new Controller();
		ArrayList<Music> mL = new ArrayList<>();
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\MP\\";
		
		Music correct = new Music(defaultPath + "correct.mp3");
		Music gamerover = new Music(defaultPath + "gameover.mp3");
		Music tic = new Music(defaultPath + "coin.mp3");
		Music good = new Music(defaultPath + "pet.mp3");
		mL.add(correct);
		mL.add(gamerover);
		mL.add(tic);
		mL.add(good);

		pethave = shop.petcheck(id);
		
		MDAO mdao = new MDAO();
		MDTO dto = new MDTO();
		Scanner sc = new Scanner(System.in);
		
		dto.setID(id);

		int point = mdao.pointCheck(dto); // 본인 포인트
		System.out.println(point);

		exit:

		while (true) {
			
			if (point >= 0) {

				while (true) {

					int num = rd.nextInt(20); // 20문제

					ArrayList<ThemaDTO> list = gdao.sportQZ();
					String word1 = list.get(num).getSport();
					int mult = mul.mulCheck(word1);

					String word = list.get(num).getSport().toUpperCase();

					System.out.println("문제 배율 : " + mult);

					int t = shop.multiplePlus(id);
					if(t>0) {
						System.out.println("보유한 배율추가 티켓 : "+t+"장");
						System.out.println("사용하시겠습니까?");
						System.out.println("[1]네 [2]아니오");
						int choice10 = sc.nextInt();
						if(choice10==1) {
							con.musicPlay(2, mL);
							shop.protectUse(id);
							mult=mult+1;
						}con.musicPlay(2, mL);
					}
					
					int point5= mul.have(id);
					System.out.println("현재금액 : "+point5);
					
					System.out.print("배팅 금액을 입력해주세요 : ");
					int money = sc.nextInt();
					if(money>point5) {
						System.out.println("잘못 입력하셨습니다.");
						break;
					}
					con.musicPlay(2, mL);
					
					String[] arr = word.split("");

					// 퀴즈 시작
					for (int i = 0; i < arr.length; i++) {
						System.out.print("_ ");
					}
					System.out.print("(" + arr.length + "글자)");
					System.out.println();

					// 초성
					String hint2 = list.get(num).getHint2().toUpperCase();
					System.out.println("초성 : " + hint2);

					int live = 0;

					int cnt = 2;

					while (true) {

						// 정답 입력
						System.out.print("입력 >> ");
						String answer = sc.next().toUpperCase();

						String[] arr1 = answer.split("");

						if (arr1.length == arr.length && live != 2) {
							for (int i = 0; i < arr.length; i++) {
								if (arr1[i].equals(arr[i])) {
									System.out.print(arr[i] + "　");
								} else {
									System.out.print(" " + "　");
								}
							}
							System.out.println();

							for (int i = arr.length - 1; i >= 0; i--) {
								System.out.print("￣ ");
							}

							live++;

						}
						System.out.println();

						if (arr1.length != arr.length) {
							con.musicPlay(1, mL);
							System.out.println("글자수에 맞게 입력해주시기 바랍니다.");
							continue;
						}

						if (word.equals(answer)) {
							con.musicPlay(2, mL);
							System.out.println("정답!");
							System.out.println("배팅금액 : " + money);
							int pointplus = mul.mulPlus(money, mult, id);
							System.out.println("획득금액 : " + money * mult);
							System.out.print("현재금액 : " + pointplus);
							if(pointplus>=10000000) {
								System.out.println(" <🏆> ");
							}else if (pointplus>=1000000) {
								System.out.println(" <💎> ");
							}else if (pointplus>=100000) {
								System.out.println(" <⛏> ");
							}else {
								System.out.println(" <💀> ");
							}
							cnt = 0;
							live = 0;
							TS.interrupt();
							break exit;
						}
						// 2번 틀리면 힌트 제공
						if (live == 2) {
							String hint = list.get(num).getHint().toUpperCase();
							System.out.println("힌트 : " + hint);
						}

						// 남은 기회 출력
						if (cnt > 0) {
							System.out.println("기회 " + cnt + "번 남았습니다.");
							cnt--;
						} else if (cnt == 0) {
							int s = shop.protectCheck(id);
							if(s>0) {
								System.out.println("현재 보유한 배팅포인트 보호권 : "+s+"장");
								System.out.println("사용하시겠습니까?");
								System.out.println("[1]네 [2]아니오");
								int choice11 = sc.nextInt();
								if(choice11 == 1) {
									con.musicPlay(2, mL);
									shop.protectUse(id);
									System.out.println("보호권이 사용되었습니다.");
									int point4= mul.have(id);
									System.out.print("현재금액 : "+point4);
									if(point4>=10000000) {
										System.out.println(" <🏆> ");
									}else if (point4>=1000000) {
										System.out.println(" <💎> ");
									}else if (point4>=100000) {
										System.out.println(" <⛏> ");
									}else {
										System.out.println(" <💀> ");
									}
									TS.interrupt();
									break exit;
								}else {
									con.musicPlay(1, mL);
									System.out.println("배팅금액이 사라졌습니다.");
									System.out.println("배팅금액 : " + money);
									System.out.println("보호된 금액 : "+(int)(money*(0.1*pethave)));
									int pointminus = mul.mulMin(money-(int)(money*(0.1*pethave)), id);
									System.out.print("현재금액 : " + pointminus);
									if(pointminus>=10000000) {
										System.out.println(" <🏆> ");
									}else if (pointminus>=1000000) {
										System.out.println(" <💎> ");
									}else if (pointminus>=100000) {
										System.out.println(" <⛏> ");
									}else {
										System.out.println(" <💀> ");
									}
//									System.exit(0);
									TS.interrupt();
									break exit;
								}
							}else {
								con.musicPlay(1, mL);
								System.out.println("배팅금액이 사라졌습니다.");
								System.out.println("배팅금액 : " + money);
								System.out.println("보호된 금액 : "+(int)(money*(0.1*pethave)));
								int pointminus = mul.mulMin(money-(int)(money*(0.1*pethave)), id);
								System.out.print("현재금액 : " + pointminus);
								if(pointminus>=10000000) {
									System.out.println(" <🏆> ");
								}else if (pointminus>=1000000) {
									System.out.println(" <💎> ");
								}else if (pointminus>=100000) {
									System.out.println(" <⛏> ");
								}else {
									System.out.println(" <💀> ");
								}
//								System.exit(0);
								
								TS.interrupt();
								break exit;
							}
						}

					}

				}

			}
		}

	}

	public void SportQuiz( String id) {
		TimerStart TS = new TimerStart();
		TS.start();
		SportQ(TS, id);

	}

}
