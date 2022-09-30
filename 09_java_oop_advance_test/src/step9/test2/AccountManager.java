package step9.test2;

import java.util.Random;
import java.util.Scanner;



public class AccountManager {
	
	private AccountManager() {};
	private static AccountManager Instance = new AccountManager();
	public static AccountManager getInstance() { // 객체 생성하지 않고 사용할 수 있게 static으로 설정!!
		return Instance;
	}
	
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager um = UserManager.getInstance();
	
	void creatAcc(int identifier) {
		
		int accCntByUser = um.userlist[identifier].accCnt;
		
		if (accCntByUser == um.ACC_MAX_CNT) {
			System.out.println("[메세지]계좌개설은 3개까지만 가능합니다.");
			return;
		}
		
		
		
		
	}
	

}
