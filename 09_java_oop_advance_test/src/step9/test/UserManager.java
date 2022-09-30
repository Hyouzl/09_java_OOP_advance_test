package step9.test;

import java.util.ArrayList;
import java.util.Scanner;


public class UserManager { //manager class 
	 
	User[] user = null;
	Scanner scan = new Scanner(System.in);
	int userCnt = 0;
	
	
	
	void addUser() { // 회원가입
		
		if (userCnt == 0) {
			user = new User[1];
		}
		else {
			User[] temp = user;
			user = new User[userCnt + 1];
			
			for (int i = 0; i < userCnt; i++) {
				user[i] = temp[i];
			}
			
			temp = null;
			
		}
		
	
		System.out.println("[가입] 아이디를 입력하세요 : ");
		String userId = scan.next();
		
		int check = 0;
		for (int i = 0; i < userCnt; i++) {
			if (user[i].Id.equals(userId)) {
				check = 1;
			}
		}
		
		if (check == 0) {
			user[userCnt].Id = userId;
			userCnt++;
		}
		else {
			System.out.println("[메세지] " + userId + "은 이미 가입된 아이디 입니다.");
		}
		
	}
	
	int logUser () {
		int identifier = -1;
		
		System.out.println("[입력] 아이디를 입력하세요 : ");
		String name = scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			if (user[i].Id.equals(name)) {
				identifier = i;
				System.out.println("[" + user[identifier].Id + "] 님 로그인.");
			} 
		}
		
		return identifier;
	}
	
	void leave() {
		
	
			
			System.out.println("[입력] 탈퇴할 아이디를 입력하세요 : ");
			String name = scan.next();
			int idx = 0;
			for (int i = 0; i < userCnt; i++) {
				if (name.equals(user[i].Id)) {
					idx = i;
				}
			}
			
			if (idx == 0) {
				System.out.println("[메세지] 아이디를 다시 확인하세요.");
				return;
			}

			System.out.println("ID : '" + name + "' 가 탈퇴되었습니다." );
			
			User[] temp = user;
			user = new User[userCnt - 1];
			
			int j = 0;
			for (int i = 0; i < idx; i++) {
				user[j++] = temp[i];
			}
			
			for (int i = idx + 1; i < userCnt; i++) {
				user[j++] = temp[i];
			}
			
			temp = null;
			userCnt--;

		
		
	}


	
	
	
		
		
		
		
				
}

