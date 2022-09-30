package step9.test;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager userManager = new UserManager();
	int identifier = -1;
	
	
	void printMainMenu() {
		while (true) {
			
			System.out.println("\n[ MEGA ATM ]");
			System.out.println("[1.로그인] [2.로그아웃] [3.회원가입] [0.종료]");
			
			int sel = scan.nextInt();
			
			if (sel == 1) { login();}
			else if (sel == 2) { logout();}
			else if (sel == 3) { join(); }
			else if (sel == 4) { leave(); } 
			else if (sel == 0) break;
		}
	}
	
	void login () {
		identifier = userManager.logUser();
		
		if (identifier == -1) {
			System.out.println("[메세지] 로그인 실패");
		}
		else {
			printAccountMenu();
		}
	}
	
	void logout () {
		
		if (identifier != -1) {
			System.out.println("[메세지] 로그아웃 되었습니다.");
			identifier = -1;
		}
		else {
			System.out.println("[메세지] 로그인 하신 후 이용하실 수 있습니다.");
		}
		
	}
	void join () {
		
		userManager.addUser();
		
	}
 	void leave () {
 		
 		userManager.leave();
 		
 	}
 	
 	void printAccountMenu () {
 		
 		while (true) {
 			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
 			int sel = scan.nextInt();
		
 			String makeAccount = Integer.toString(ran.nextInt(90001) + 10000);
		
 			if (sel == 1) {
			
 				if (userManager.user[identifier].accountCnt == 0) {
				
 					userManager.user[identifier].acc = new Account[1];
 					userManager.user[identifier].acc[0] = new Account(); // 계좌 생성하는 거 잊지말기
 					userManager.user[identifier].acc[0].number = makeAccount;
				
 					System.out.println("[메세지] '" + makeAccount + "' 계좌가 생성되었습니다.");
				
 					userManager.user[identifier].accountCnt ++;
				
 				}
 				else {
				
 					int cnt = userManager.user[identifier].accountCnt;
 					Account[] temp = userManager.user[identifier].acc;
 					userManager.user[identifier].acc = new Account[cnt + 1];
					
 					for (int i = 0; i < cnt; i++) {
 						userManager.user[identifier].acc[i] = temp[i];
 					}
				
 					userManager.user[identifier].acc[cnt] = new Account();
 					userManager.user[identifier].acc[cnt].number = makeAccount;
				
				
 					userManager.user[identifier].accountCnt ++;
 					System.out.println("[메세지] '" + makeAccount + "' 계좌가 생성되었습니다.");
				
 				}
 			}
 			else if (sel == 2) {
				int cnt = userManager.user[identifier].accountCnt;
			
				if (cnt == 0) {
					System.out.println("더 이상 삭제할 계좌가 없습니다.");
				}
				
				else if (cnt == 1) {
					System.out.println("[메시지] 계좌번호 :'"+ userManager.user[identifier].acc[0].number+"' 삭제 되었습니다.\n");
					userManager.user[identifier].acc = null;
				}
			
			
				System.out.println("삭제하고 싶은 계좌 번호를 입력하세요 : ");
				String name = scan.next();
				int idx = 0;
				for (int i = 0; i < cnt; i++) {
					if (userManager.user[identifier].acc[i].number.equals(name)) {
						idx = i;
					}
				}
			
				if (idx == 0) {
					System.out.println("[메세지] 계좌번호를 확인하세요.");
					continue;
				}
			
				else {
					Account[] temp = userManager.user[identifier].acc;
					userManager.user[identifier].acc = new Account[cnt - 1];
			
					for (int i = 0; i < idx; i++) {
						userManager.user[identifier].acc[i] = temp[i];
					}
					for( int i = idx; i < cnt; i++) {
						userManager.user[identifier].acc[i] = temp[i+1];
					}
			
					userManager.user[identifier].accountCnt--;
				}
			}
		
			else if (sel == 3) {
				
				if (userManager.user[identifier].accountCnt == 0) {
					System.out.println("[메세지] 생성된 계좌가 없습니다.");
				}
				else {
				userManager.user[identifier].pirntAcc();
				}
				
			
			}
			else if (sel == 0) {
				logout();
				break;
			}
 		} 
 	}
	

}
