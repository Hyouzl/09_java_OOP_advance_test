package step9.test2;

import java.util.Scanner;

public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	
	private UserManager() {};
	private static UserManager instance = new UserManager();
	static UserManager getInstance () {
		return instance;
	}
	
	
	
	
	final int ACC_MAX_CNT = 3;
	int userCnt = 0;
	User[] userlist = null;
	
	void printAllUser() {
		
		for (int i = 0; i < userCnt; i++) {
			
		}
		
	}
	
	boolean isDupleId (String id) {
		
		for (int i = 0; i < userCnt; i++) {
			if (userlist[i].id.equals(id)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	void joinMember () {
		System.out.print("[회원가입]아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("[회원가입]비밀번호를 입력하세요 : ");
		String pw = scan.next();
		
		if (isDupleId(id)) {
			System.out.println("[메세지]아이디가 중복됩니다.");
		}
		else {
			if (userCnt == 0) {
				userlist = new User[userCnt + 1];
				userlist[userCnt] = new User();
			}
			
			else {
				User[] temp = userlist;
				userlist = new User[userCnt + 1];
				userlist[userCnt] = new User();
				
				for (int i = 0; i < userCnt; i++) {
					userlist[i] = temp[i];
				}
				
				temp = null;
			}
			
			userlist[userCnt].id = id;
			userlist[userCnt].pw = pw;
			userCnt++;
		}
	}
	
	int logUser() {
		int identifier = -1;
		
		System.out.println("[로그인]아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("[로그인]패스워드를 입력하세요 : ");
		String pw = scan.next();


		for (int i = 0; i < userCnt; i++) {
			if (userlist[i].id.equals(id) && userlist[i].pw.equals(pw)) {
				System.out.println("[" + id + "님, 환영합니다.]");
				identifier = i;
			}
		}
	
		
		return identifier;
		
	}

}
