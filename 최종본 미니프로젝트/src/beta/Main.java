package beta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MDAO mdao = new MDAO();
		shop2 shop = new shop2();
		shop s = new shop();
		가위바위보 game = new 가위바위보();
		pet기능 pett = new pet기능();
		FruitQz FQ = new FruitQz();
		CountryQz CQ = new CountryQz();
		AnimalQz AQ = new AnimalQz();
		SportQz SQ = new SportQz();
		JobQz JQ = new JobQz();

		MP3Player mp3 = new MP3Player();
		Controller con = new Controller();
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\MP\\";
		Music start = new Music(defaultPath + "basic.mp3");// 1
		Music mart = new Music(defaultPath + "shop.mp3");
		Music correct = new Music(defaultPath + "correct.mp3");
		Music coin = new Music(defaultPath + "coin.mp3");
		Music pet = new Music(defaultPath + "pet.mp3");// 5
		Music mymoney = new Music(defaultPath + "mymoney.mp3");
		Music join = new Music(defaultPath + "join.mp3");
		Music rsp = new Music(defaultPath + "rsp.mp3");
		Music quiz = new Music(defaultPath + "quiz.mp3");

		ArrayList<Music> mL = new ArrayList<>();
		mL.add(start);// 0
		mL.add(mart);
		mL.add(correct);// 2
		mL.add(coin);
		mL.add(pet);// 4
		mL.add(mymoney);
		mL.add(join);// 6
		mL.add(rsp);
		mL.add(quiz);// 8

		int index = 0;

		while (true) {
			if (con.mp3.isPlaying()) {
				con.mp3.stop();
			}
			con.musicPlay(index, mL);

			System.out.println("                                                                                                                         `                                                                              \r\n"
					+ "                                                                                                                      ## `                                                                              \r\n"
					+ "````  `             `   `       `   ` ``````  `              `` `    ``````    `          ``     ```            ``````##``  `   ```           ``   ``  `            ` ``         ` `  ```````   ` ``    \r\n"
					+ " ####``              ###``      ``⢀⣀⣤⣴⣶⣶⣶⣶⣦⣤⣄⡀               `  ###############`            `#####               ###########`     `###########``` #####```          ### ``          ⢀⣀⣤⣴⣶⣶⣶⣶⣦⣤⣄⡀        \r\n"
					+ "` ####              ####     ` ⣀⣤⣾⣿⡿⠿⠛⠛⠛⠛⠛⠛⠻⢿⣿⣿⣦⣄`           `##### `  `   `####            ######``         ``#####  ##``####` `   ` `###`    `  ######``          ###`     ``  ⣀⣤⣾⣿⡿⠿⠛⠛⠛⠛⠛⠛⠻⢿⣿⣿⣦⣄`    \r\n"
					+ "  `###  `        ```###`   ```⢠⣼⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⣿⣷⣄` `      `####``                         ###` ###   `       #### `  ##`   `         `###        ###`###` ``       ###`     ` ⢠⣼⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⣿⣷⣄`   \r\n"
					+ " ```###  `      ```###````` `⣰⣿⡿⠋⠀⠀⠀⠀⠀⣿⡇⠀⢸⣿⡇⠀⠀⠀⠀⠀⠈⢿⣿⣦⡀       ####  `                        ####```###          ###`    ##` ```         `###        ###``###` `       ###`     `⣰⣿⡿⠋⠀⠀⠀⠀⠀⣿⡇⠀⢸⣿⡇⠀⠀⠀⠀⠀⠈⢿⣿⣦⡀` \r\n"
					+ "  ` #### `        ####`     ⣸⣿⡿⠀⠀⠀⠸⠿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣶⣄⠀⠀⠀⠀⢹⣿⣷``   ####``                        ``### ` `###```       ####    ##`             `###        ###` `####        ###`   ``⣸⣿⡿⠀⠀⠀⠸⠿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣶⣄⠀⠀⠀⠀⢹⣿⣷` \r\n"
					+ "    `###         `###`     `⢠⣿⡿⠁⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠈⣿⣿⣿⠀⠀⠀⠀⠀⢹⣿⣧    #### `                         ###`   ``###``        #####  ##`             `###        ###` ` #### ``    ###`   `⢠⣿⡿⠁⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠈⣿⣿⣿⠀⠀⠀⠀⠀⢹⣿⣧``\r\n"
					+ "    ``###       `###      `⠀⣾⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⢀⣠⣿⣿⠟⠀⠀⠀⠀⠀⠈⣿⣿    ###`                         `####    ```###        `  #########``          `###        ###` `  #### `    ###`   `⠀⣾⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⢀⣠⣿⣿⠟⠀⠀⠀⠀ ⠈⣿⣿ \r\n"
					+ "    ``####   ` `####` `  ``⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡿⠿⠿⠿⣿⣿⣥⣄⠀⠀⠀⠀⠀⠀⣿⣿⠀` `###``                      ` `###` ``` ` ###````      ```  `########``      `###        ###`     `###     ###`  `` ⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡿⠿⠿⠿⣿⣿⣥⣄⠀⠀⠀⠀ ⠀⣿⣿  \r\n"
					+ "     ``###``  ``###` ``     ⢿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⢻⣿⣿⣧⠀⠀⠀⠀⢀⣿⣿    #### `                     ``################` `       ```` ##`  ####`      `###        ###`    ` `###    ###`    `⢿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⢻⣿⣿⣧⠀⠀⠀⠀⢀⣿⣿`\r\n"
					+ "       `### ```### `       `⠘⣿⣷⡀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⣼⣿⣿⡿⠀⠀⠀⠀⣸⣿⡟⠀`  `###                        ##################``            ##` ` `###      `###        ###`     `` ###`  ###`   ` ⠘⣿⣷⡀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⣼⣿⣿⡿⠀⠀⠀⠀⣸⣿⡟ \r\n"
					+ "        ####` ###``        ``⢹⣿⣷⡀⠀⠀⢰⣶⣿⣿⣿⣷⣶⣶⣾⣿⣿⠿⠛⠁⠀⠀⠀⣸⣿⡿⠀    `###`             `       `###`           ####    ` ``` `  ##` ` `###      `###        ###`       ``###` ###`      ⢹⣿⣷⡀⠀⠀⢰⣶⣿⣿⣿⣷⣶⣶⣾⣿⣿⠿⠛⠁⠀⠀⠀⣸⣿⡿` \r\n"
					+ "        `###``##`  `        ``⠹⣿⣷⣄⠀⠀⠀⠀⠀⣿⡇⠀⢸⣿⡇⠀⠀⠀⠀⠀⢀⣾⣿⠟⠁`  `  `##### ``         ``     `###             `####    ###```  ##` ` ####      `###        ###`          #######`     ``⠹⣿⣷⣄⠀⠀⠀⠀⠀⣿⡇⠀⢸⣿⡇⠀⠀⠀⠀⠀⢀⣾⣿⠟⠁ \r\n"
					+ "       `` ######   `          `⠘⢻⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⡿⠋`          ######``  ```#####````####`           ```###````################`  ``````###``````  ###`          `######`     `` ⠘⢻⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⡿⠋`  \r\n"
					+ "          `####`                ⠈⠛⢿⣿⣷⣶⣤⣤⣤⣤⣤⣤⣴⣾⣿⣿⠟⠋               `#############``   ####```             `###`     `#########``     `########### `  ###`            #####  `      `⠈⠛⢿⣿⣷⣶⣤⣤⣤⣤⣤⣤⣴⣾⣿⣿⠟⠋    \r\n"
					+ "          `                        `⠈⠉⠛⠻⠿⠿⠿⠿⠟⠛⠉⠁`               `    ` `  `  ``  ` ` ` `                `` `    `` `  ## ` `      ``            ``   `             `   ```       ````⠈⠉⠛⠻⠿⠿⠿⠿⠟⠛⠉⠁`      \r\n"
					+ "                                                                                                                    ` ##`                                                                               \r\n"
					+ "                                                                                                                    ````                                                                                ");
			System.out.println("[1]로그인 [2]회원가입 [3]게임설명 [4]종료");

			int choice = sc.nextInt();

			// 로그인
			if (choice == 1) {

				System.out.print("아이디 입력: ");
				String ID = sc.next();
				System.out.print("비밀번호 입력: ");
				String PW = sc.next();

				MDTO dto = new MDTO();
				dto.setID(ID);
				dto.setPW(PW);

				MDTO result = mdao.login(dto);

				// 로그인 후 선택화면
				if (result != null) {
					con.mp3.stop();
					while (true) {
						if (con.mp3.isPlaying()) {
							con.mp3.stop();
						}
						con.mp3.stop();
						con.musicPlay(6, mL);

						System.out.println();
						System.out.println("✧･ﾟ: *✧･ﾟ:* 메뉴를 선택하세요 *:･ﾟ✧*:･ﾟ✧");
						System.out.println("[1]게임시작 [2]보유포인트/펫 보기 [3]랭킹 [4]상점 [5]가위바위보 [6]로그아웃");
						int menu = sc.nextInt();

						if (menu == 1) {
							exit: while (true) {
								// 게임시작
								System.out.print("[1]과일 [2]수도 [3]동물 [4]스포츠 [5]직업 [0]나가기 >> ");
								System.out.println("제한시간은 40초 입니다.");
								int choiceThema = sc.nextInt();

								// =========================================과일=============================================================

								if (choiceThema == 1) {
									if (con.mp3.isPlaying()) {
										con.mp3.stop();
									}
									con.musicPlay(8, mL);
									FQ.FruitQuiz(ID);
								}

								// =========================================수도=============================================================

								if (choiceThema == 2) {
									if (con.mp3.isPlaying()) {
										con.mp3.stop();
									}
									con.musicPlay(8, mL);
									CQ.CountryQuiz(ID);
								}

								// =========================================동물=============================================================

								if (choiceThema == 3) {
									if (con.mp3.isPlaying()) {
										con.mp3.stop();
									}
									con.musicPlay(8, mL);

									AQ.AnimalQuiz(ID);
								}

								// =========================================스포츠=============================================================

								if (choiceThema == 4) {
									if (con.mp3.isPlaying()) {
										con.mp3.stop();
									}
									con.musicPlay(8, mL);
									SQ.SportQuiz(ID);
								}

								// =========================================직업===============================================================

								if (choiceThema == 5) {
									if (con.mp3.isPlaying()) {
										con.mp3.stop();
									}
									con.musicPlay(8, mL);
									JQ.JobQuiz(ID);
								}

								System.out.print("[1]다음게임 진행 [2]나가기 >> ");
								int ac = sc.nextInt();

								if (ac == 1) {
									continue;
								}
								if (ac == 2) {
									break exit;
								}

							}

						} else if (menu == 2) {
							// 현재 보유포인트/펫 보기
							System.out.print("[1]보유 포인트 보기 [2]보유 펫 보기 [3]나가기 >> ");
							int choice6 = sc.nextInt();

							if (choice6 == 1) {
								mdao.have(dto);
								con.mp3.stop();
								con.musicPlay(5, mL);

							} else if (choice6 == 2) {
								ArrayList<PetDTO> list = pett.petImformation(ID);
								int listsize = list.size();

								if (listsize > 0) {
									System.out.println("✧･ﾟ: *✧･ﾟ:* 현재보유펫 *:･ﾟ✧*:･ﾟ✧");

									for (int i = 0; i < listsize; i++) {
										PetDTO result3 = list.get(i);
										String image = pett.petImage(result3.getPet_number());
										System.out
												.println("No." + result3.getPet_number() + " " + result3.getPet_name());
										System.out.println(image);
										System.out.println();
									}

								} else {
									con.mp3.stop();
									System.out.println("보유한 펫이 없습니다.");

								}
							} else {
								if (con.mp3.isPlaying()) {
									con.mp3.stop();
								}
								con.mp3.stop();
								continue;
							}

						} else if (menu == 3) {
							// 랭킹
							System.out.println("✧･ﾟ: *✧･ﾟ:* 랭킹 보기 *:･ﾟ✧*:･ﾟ✧");

							ArrayList<MDTO> list = mdao.rank();
							System.out.println("순위\tID\t닉네임\t보유 포인트");

							for (int i = 0; i < list.size(); i++) {
								System.out.print((i + 1) + "위\t" + list.get(i).getID() + "\t" + list.get(i).getNICK()
										+ "\t" + list.get(i).getPOINT());
								
								if(list.get(i).getPOINT()>=10000000) {
									System.out.print(" <🏆> ");
								}else if (list.get(i).getPOINT()>=1000000) {
									System.out.print(" <💎> ");
								}else if (list.get(i).getPOINT()>=100000) {
									System.out.print(" <⛏> ");
								}else {
									System.out.print(" <💀> ");
								}
								System.out.println();
							}

						} else if (menu == 4) {
							if (con.mp3.isPlaying()) {
								con.mp3.stop();
							}
							index = 1;
							con.musicPlay(index, mL);
							System.out.println("✧･ﾟ: *✧･ﾟ:* 상점 *:･ﾟ✧*:･ﾟ✧");
							System.out.print("[1]일반뽑기 [2] 펫 뽑기 [3]나가기 >>");
							int choice2 = sc.nextInt();

							if (choice2 == 1) {
								// 상점-일반
								mdao.have(dto);
								while (true) {
									System.out.println();
									System.out.println("뽑기티켓 : 10,000 point");
									System.out.println("뽑기를 진행할까요?");
									System.out.print("[1]네 [2]아니오 >> ");
									int choice1 = sc.nextInt();

									if (choice1 == 1) {
										con.musicPlay2(3, mL);

										if (mdao.LP(dto) < 10000) {
											mdao.low(dto);

										} else {

											System.out.println("보유금액 있을때");
											shop.gacha(ID);
										}

									} else {
										
										if (con.mp3.isPlaying()) {
											con.mp3.stop();
										}
										break;

									}
								}
							} else if (choice2 == 2) {
								// 상점-펫
								int p = s.petchekct(ID);
								System.out.println();
								System.out.print("보유한 펫 뽑기티켓 : ");
								System.out.println(p + "장");
								System.out.println("펫 뽑기를 진행할까요?");
								System.out.print("[1]네 [2]아니오 >> ");
								int choice1 = sc.nextInt();
								if (choice1 == 1) {
									con.mp3.stop();
									con.musicPlay(4, mL);
									if (p > 0) {
										shop.petgacha(ID);
									} else {
										if (con.mp3.isPlaying()) {
											con.mp3.stop();
										}
										System.out.println("보유한 펫 뽑기티켓이 없습니다.");
									}
								} else {
									if (con.mp3.isPlaying()) {
										con.mp3.stop();
									}
									continue;
								}
							} else {
								if (con.mp3.isPlaying()) {
									con.mp3.stop();
								}
								index = 0;
								con.musicPlay(index, mL);
								continue;
							}

						} else if (menu == 5) {
							System.out.println();
							if (con.mp3.isPlaying()) {
								con.mp3.stop();
							}
							con.musicPlay(7, mL);
							System.out.println("✧･ﾟ: *✧･ﾟ:* 가위바위보 *:･ﾟ✧*:･ﾟ✧");
							System.out.print("[1]가위바위보 게임 [2]가위바위보 상점 [3]나가기");
							int choice3 = sc.nextInt();
							if (choice3 == 1) {
								game.game2(ID);
							} else if (choice3 == 2) {
								int ticket = s.ticketcheck(ID);
								System.out.println();
								System.out.print("보유한 가위바위보 티켓 : ");
								System.out.println(ticket + "장");
								System.out.print("[1]사용 [2]나가기");
								int choice4 = sc.nextInt();
								if (choice4 == 1) {
									if (ticket > 0) {
										shop.gacha2(ID);
									} else {
										System.out.println("보유한 가위바위보 티켓이 없습니다.");
									}
								}

							} else {
								continue;
							}

						} else {
							// 로그아웃
							con.mp3.stop();
							break;
						}
					}

				}

			} else if (choice == 2) {

				// 회원가입
				System.out.println("✧･ﾟ: *✧･ﾟ:* 회원가입 *:･ﾟ✧*:･ﾟ✧");
				System.out.print("ID 입력 : ");
				String joinId = sc.next();

				int result = mdao.idCheck(joinId);
				if (result == 0) {
					System.out.println("사용가능한 ID 입니다.");
				} else {
					System.out.println("이미 사용중인 ID입니다.");
					continue;
				}

				System.out.print("비밀번호 입력 : ");
				String joinPw = sc.next();
				System.out.print("닉네임 입력 : ");
				String joinNick = sc.next();

				MDTO dto = new MDTO();
				dto.setID(joinId);
				dto.setPW(joinPw);
				dto.setNICK(joinNick);

				int cnt = mdao.join(dto);

			} else if (choice == 3) {

				// 게임설명
				while (true) {
					System.out.println("✧･ﾟ: *✧･ﾟ:* How to play: 어떻게 할까? *:･ﾟ✧*:･ﾟ✧");
					System.out.println("[1]게임방법 [2]랭킹 [3]상점 [4]가위바위보 [5]나가기");
					int how = sc.nextInt();

					// if문으로 게임설명 출력
					if (how == 1) {
						System.out.println();
						howtoplay.hp1();

					} else if (how == 2) {
						System.out.println();
						howtoplay.hp2();

					} else if (how == 3) {
						System.out.println();
						howtoplay.hp3();

					} else if (how == 4) {
						System.out.println();
						howtoplay.hp4();

					} else {
						break;
					}
				}

			} else {
				con.mp3.stop();
				System.out.println("System: 게임을 종료합니다. 다음에 또 만나요!");
				break;
			}

		}

	}

}
