package step9.test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



public class FileManager {
	
	
	private FileManager () {}
	private static FileManager Instance = new FileManager();
	public static FileManager getInstance() {
		return Instance;
	}
	
	String fileName = "ATM.txt";
	String data = "";
	UserManager um = UserManager.getInstance();
	
	void setData() {
		
		int userCount = um.userCnt;
		data += userCount;
		data += "\n";
		
		for (int i = 0; i < userCount; i++) {
			data += um.userlist[i].id;
			data += "\n";
			data += um.userlist[i].pw;
			data += "\n";
			data += um.userlist[i].accCnt;
			data += "\n";
			
			if (um.userlist[i].accCnt == 0) {
				data += "0\n";
			}
			else {
				for (int j = 0; j < um.userlist[i].accCnt; j++) {
					data += um.userlist[i].acc[j].accNumber;
					data += "/";
					data += um.userlist[i].acc[j].money;
					if (j != um.userlist[i].accCnt - 1) {
						data += ",";
					}
				}
				data += "\n";
			}
		}
		
		
	}
	
	void save()  {
		setData();
		
		FileWriter fw = null; //파일 만드는 객체
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) try { fw.close();} catch (Exception e2) { e2.printStackTrace(); }
		}
	}
	
	void load() {
		
		File file = new File (fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
		
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					data += line;
					data += "\n";
				}
			
				String[] tmp = data.split("\n");
				um.userCnt = Integer.parseInt(tmp[0]);
				um.userlist = new User[um.userCnt];
				
				for (int i = 0; i <um.userCnt; i++) {
					um.userlist[i] = new User();
				}
				
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
