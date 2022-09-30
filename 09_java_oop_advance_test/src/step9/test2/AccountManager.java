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
		else {
			String makeAccount = "";
			while (true) {
					makeAccount= ran.nextInt(9000000) + 1000001 + "";
					if(!um.getCheckAcc(makeAccount)) {
						break;
					}
				}
				
				um.userlist[identifier].acc[accCntByUser].accNumber = makeAccount;
				um.userlist[identifier].accCnt++;
				System.out.println("[메세지]'" + makeAccount + "'계좌가 생성되었습니다.");
				
		}
	}
	
	
	
	void deleteAcc(int identifier) {
		
		int accCntbyUser = um.userlist[identifier].accCnt;
		
		if (accCntbyUser == 0) {
			System.out.println("[메세지]생성된 계좌가 없습니다.");
		}
		else {
			System.out.print("삭제할 계좌의 번호를 입력하세요 : ");
			String deleteAcc = scan.next();
			int deleteIdx = -1;
			
			for (int i = 0; i < accCntbyUser; i++) {
				if (deleteAcc.equals(um.userlist[identifier].acc[i].accNumber)) {
					deleteIdx = i;
				}
			}
			
			if (deleteIdx == -1) {
				System.out.println("[메세지]계좌번호를 확인하세요.");
			}
			else {
				Account[] temp = um.userlist[identifier].acc;
				um.userlist[identifier].acc = new Account[accCntbyUser - 1];
			
				for (int i = 0; i < deleteIdx ; i++) {
					um.userlist[identifier].acc[i] = temp[i];
				}
				for (int i = deleteIdx; i < accCntbyUser - 1; i++) {
					um.userlist[identifier].acc[i] = temp[i + 1];
				}
				
				um.userlist[identifier].accCnt--;
				
			}
	
		
		}
	}
	
	
	void printAcc(int identifier) {
		
		System.out.println("========================");
		System.out.println("ID : " + um.userlist[identifier].id);
		System.out.println("========================");
		for (int i = 0; i < um.userlist[identifier].accCnt; i++) {
			System.out.println("accNumber:" + um.userlist[identifier].acc[i].accNumber + " / money: " + um.userlist[identifier].acc[i].money);
		}
		System.out.println("========================");
	}

}
