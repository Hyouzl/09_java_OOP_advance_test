package step9.test3;

import java.util.Scanner;

public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	
	private UserManager() {}
	private static UserManager instance = new UserManager();
	public UserManager getInstance() {
		return instance;
	}
	
	
	User[] userList;
	int userCnt;
	int identifier = -1;
	
	
	void setDummy()  {
		
		
		
		
	}
	
	
	boolean checkId (String id) {
		
		
		for (int i = 0; i < userCnt; i++) {
			if (userList[i].id.equals(id)) {
				return true;
			}
		}
	
		return false;
	}
	
	
	void joinMember() {
		System.out.print("[가입] 아이디를 입력하세요 : ");
		String id = scan.next();
	
		if (checkId(id)) {
	
			System.out.println("[메세지] 아이디가 중복됩니다.");
			return;
			
		}
		
		System.out.print("[가입] 패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		
		if (userCnt == 0) {
			userList = new User[1];
			userList[0] = new User(id,pw);
		}
		else {
			
			User[] temp = userList;
			userList = new User[userCnt + 1];
			
			for (int i = 0; i < userCnt; i++) {
				temp[i] = userList[i];
			} 
			
			userList[userCnt] = new User(id,pw);
			
			temp = null;
		}
		
		userCnt++;
		System.out.println("[메세지] 회원가입을 완료하였습니다.");
	}
	
	
	void leaveMember() {
		
		if (userCnt == 1) {
			userList = null;
		}
		
		else {
			User[] temp = userList;
			userList = new User[userCnt - 1];
			
			for (int i = 0; i < identifier; i++) {
				userList[i] = temp[i];
			}
			for (int i = identifier; i < userCnt -1 ; i++) {
				userList[i] = temp[i+1];
			}
			
			temp = null;
		}
		
		userCnt--;
		
		System.out.println("[메세지] 탈퇴되었습니다.\n");
		logoutUser();

	}
	
	void logInUser() {
		
		System.out.println("[로그인] 아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("[로그인] 패스워드를 입력하세요 : ");
		String pw = scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			
			if (userList[i].id.equals(id) && userList[i].pw.equals(pw)) {
				identifier = i;
			}
			
		}
		if (identifier == -1) {
			System.out.println("[메세지] 아이디와 패스워드가 틀렸습니다.");
		}
		
		else {
			System.out.println( "[메세지] "  + id + "님, 환영합니다.");
			afterloginMenu();
		}
	}
	
	void logoutUser() {
		identifier = -1;
		
		System.out.println("[메세지] 로그아웃되었습니다.");
	}
 	
	void afterloginMenu() {
		
		
		while(true) {
			System.out.println("[" + userList[identifier].id + "님, 로그인]");
			
			System.out.println("[1]계좌생성 [2]입금하기 [3]출금하기 [4]이체하기 [5]계좌조회 ");
			
			
		}
		
		
	}
	

}
