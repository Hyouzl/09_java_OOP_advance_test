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
			System.out.print((i+1) + ".ID(" + userlist[i].id + ")\tPW(" + userlist[i].pw + ")\t");
			if (userlist[i].accCnt != 0) {
				for (int j = 0; j < userlist[i].accCnt; j++) {
					System.out.print("(" + userlist[i].acc[j].accNumber + ":" + userlist[i].acc[j].money + ")");
				}
			}
			System.out.println();
		}
	}
		
	
	
	boolean getCheckAcc(String account) {
		
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userlist[i].accCnt; j++) {
				if (account.equals(userlist[i].acc[j].accNumber)) {
					return true;
				}
			}
		}
		return false;
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
	
	void deleteMember (int identifier) {
		
		User[] temp = userlist;
		userlist = new User[userCnt-1];
		
		for (int i = 0; i < identifier; i++) {
			userlist[i] = temp[i];
		}
		for (int i = identifier; i < userCnt - 1; i ++) {
			userlist[i] = temp[i+1];
		}
		
		System.out.println("[메세지]탈퇴되었습니다.");
	}


}
