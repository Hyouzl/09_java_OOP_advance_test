package step9.test2;

public class User {
	
	String id;
	String pw;
	Account[] acc = new Account[UserManager.getInstance().ACC_MAX_CNT];
	int accCnt;

}
