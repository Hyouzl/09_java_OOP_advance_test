package step9.test3;

import java.util.Scanner;

public class ATM {
	

	Scanner scan = new Scanner(System.in);
	UserManager um;
	
	
	
		void showMenu() {
			
			while (true) {
				System.out.println("[MEGA ATM]");
				System.out.println("[1]회원가입");
				System.out.println("[2]로그인");
				System.out.println("[0]종료");
				
				System.out.print("메뉴를 선택하세요 : ");
				int sel = scan.nextInt();
				
				
				if (sel == 1) {
					um.getInstance().
				}
				
				
			
			
			}
			
		}

}
