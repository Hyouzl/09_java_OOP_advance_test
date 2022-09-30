package step9.test;

public class User {
	
	String Id;
	int accountCnt;
	Account[] acc;
	
	void pirntAcc() {
		
		for (int i = 0; i < accountCnt; i++) {
			acc[i].printOwnAccount();
		}
	}
	
	

}
