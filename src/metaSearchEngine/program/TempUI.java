package metaSearchEngine.program;

import java.util.List;

public class TempUI {
	
	
	static void login(Database db, String username, String password) {
		List<List<String>> res = db.query("SELECT \"Password\" FROM \"Users\" WHERE \"Username\" = '" + username + "';");
		System.out.println(res);
	}
	
	public static void main(String [] args) {
		Database db = new Database("localhost",5432,"Tripplaner","postgres","tester123");
		login(db,"Notandi","test");
	}
	
	
}
