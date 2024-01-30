package beta;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuizFruit {

//	static int correct = 0; // 정답갯수 베팅한 포인트
//	static int wrong = 0; // 틀린 갯수 획득한 포인트
//	static int proNum = 0; // 문제 갯수 현재 포인트

	static Random rd = new Random();
	static GameDAO gdao = new GameDAO();
	Scanner sc = new Scanner(System.in);
	ThemaDTO thdto = new ThemaDTO();
	multiple mul = new multiple();

	public void letsGo() {
		TimerStart timer = new TimerStart();
		timer.start();
	}

	private static class FruitQ extends Thread {

		public void run() {
			
			MDAO mdao = new MDAO();
			MDTO dto = new MDTO();
			Scanner sc = new Scanner(System.in);

			int point = mdao.pointCheck(dto); // 본인 포인트


			while (true) {

				if (point >= 0) {

					while (true) {

						int num = rd.nextInt(20); // 20문제

						ArrayList<ThemaDTO> list = gdao.fruitQZ();

						String word = list.get(num).getFruit().toUpperCase();

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

								// 2번 틀리면 힌트 제공
								if (live == 2) {
									String hint = list.get(num).getHint().toUpperCase();
									System.out.println("힌트 : " + hint);
								}
							}
							System.out.println();

							if (arr1.length != arr.length) {
								System.out.println("글자수에 맞게 입력해주시기 바랍니다.");
								continue;
							}

							if (word.equals(answer)) {
								System.out.println("정답!");
								System.exit(0);
							}

							// 남은 기회 출력
							if (cnt > 0) {
								System.out.println("기회 " + cnt + "번 남았습니다.");
								cnt--;
							} else if (cnt == 0) {
								System.out.println("끗...");
								System.exit(0);
							}

						}

					}

				}
			}
		}
	}

	private static class TimerStart extends Thread {

		public void run() {
			FruitQ game = new FruitQ();

			System.out.println("START");
			game.start();

			for (int i = 20; i >= 0; i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (i == 15) {
					System.out.println("5초 경과!");
				}
				if (i == 10) {
					System.out.println("10초 경과!");
				}
				if (i <= 5) {
					System.out.println(i + "초");
				}

				if (i == 0 || game.isInterrupted()) {
					System.out.println("게임 종료!");
					System.exit(0); // THread 종료.
					game.interrupt();
				}

			}

		}
	}

	
	public void quiz(int money, String id) {
		
		MDAO mdao = new MDAO();
		MDTO dto = new MDTO();
		Scanner sc = new Scanner(System.in);

		int point = mdao.pointCheck(dto); // 본인 포인트
		
		exit:

		while (true) {

			if (point >= 0) {
			

				while (true) {

					int num = rd.nextInt(20); // 20문제

					ArrayList<ThemaDTO> list = gdao.fruitQZ();
					String word1 = list.get(num).getFruit();
					int mult =mul.mulCheck(word1);

					String word = list.get(num).getFruit().toUpperCase();
					
					System.out.println("문제 배율 : "+mult);

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
							System.out.println("글자수에 맞게 입력해주시기 바랍니다.");
							continue;
						}

						if (word.equals(answer)) {
							System.out.println("정답!");
							System.out.println("배팅금액 : "+money);
							int pointplus = mul.mulPlus(money, mult, id);
							System.out.println("획득금액 : "+money*mult);
							System.out.println("현재금액 : "+pointplus);
							cnt=0;
							live =0;
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
							System.out.println("끗...");
							System.out.println("배팅금액이 사라졌습니다.");
							System.out.println("배팅금액 : "+money);
							int pointminus = mul.mulMin(money, id);
							System.out.println("현재금액 : "+pointminus);
							break exit;
						}

					}

				}

			}
		}
	}
	
}