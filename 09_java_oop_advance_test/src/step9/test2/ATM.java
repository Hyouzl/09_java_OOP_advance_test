package step9.test2;

import java.util.Scanner;

public class ATM {
	
	
	Scanner scan = new Scanner(System.in);
	int identifier = -1;
	UserManager um = UserManager.getInstance();
	
	void play() {
		
		um.printAllUser();
		
		
		while(true) {
			System.out.println("[ATM]");
			System.out.println("[1.회원가입]\n[2.로그인]\n[0.종료]\n");
			System.out.println("메뉴선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
			}
		}
		
	}
	
	void login() {
		identifier = um.logUser();
		if(identifier == -1) System.out.println("[메세지]아이디와 패스워드를 확인해주세요.");
		else loginMenu();
	}
	
	
	void loginMenu() {
		
		while(true) {
			System.out.println("[1.계좌생성]\n[2.계좌삭제]\n[3.조  회]\n[4.회원탈퇴]\n[0.로그아웃]");
			System.out.println("메뉴선택 : ");
			int sel = scan.nextInt();
			
			AccountManager am = AccountManager.getInstance(); 
			
			if (sel == 1) {
				
				am.creatAcc(identifier);
				
				
			}
			
		}
		
	}
	
	void join() {
		um.joinMember();
	}
	
	

}
