package metaSearchEngine.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TempUI {
	
	
	static User login(Database db, String username, String password) throws EmptySQLreturnException {
		String sql = "SELECT \"Password\" FROM \"Users\" WHERE \"Username\" = ?;";
		Connection c = db.connect();
		PreparedStatement prepStmt;
		User user = null;
		
		try {
			prepStmt = c.prepareStatement(sql);
			prepStmt.setString(1, username);
			List<List<String>> res = db.query(c,prepStmt);
			if (!res.isEmpty()) {
				
				//Trim all elements in list
				List<String> trimmedRes = new ArrayList<String>(res.get(0).size());
				for ( int i = 0; i < res.get(0).size(); i++ ) {
				    trimmedRes.add( res.get(0).get(i).trim() );
				}
				
				//Check if passwords match
				if (trimmedRes.contains(password)) {
					String sqlUserInfo = "SELECT * FROM \"Users\" WHERE \"Username\" = ?;";
					PreparedStatement prepStmtUserInfo;
					
					try {
						Connection conn = db.connect();
						prepStmtUserInfo = conn.prepareStatement(sqlUserInfo);
						prepStmtUserInfo.setString(1, username);
						List<List<String>> resUserInfo = db.query(conn,prepStmtUserInfo);
						
						if (!resUserInfo.isEmpty()) {
							List<String> trimmedResUserInfo = new ArrayList<String>(resUserInfo.get(0).size());
							for ( int i = 0; i < resUserInfo.get(0).size(); i++ ) {
								if (resUserInfo.get(0).get(i)==null) {
									trimmedResUserInfo.add( resUserInfo.get(0).get(i));
								} else {
									trimmedResUserInfo.add( resUserInfo.get(0).get(i).trim());
								}
							}
							int newId = Integer.parseInt(trimmedResUserInfo.get(0));
							String newUsername = trimmedResUserInfo.get(2);
							String newAge = trimmedResUserInfo.get(3);
							String newEmail = trimmedResUserInfo.get(4);
							boolean newAdmin = Boolean.valueOf(trimmedResUserInfo.get(5));
							
							user = new User(newId,newUsername,newEmail,newAdmin);
							
							if (newAge != null) user.setAge(Integer.parseInt(newAge));
						} else {
							throw new EmptySQLreturnException("Sorry, the query had no return");
						} 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
				} else {
					
				}
			} else {
				throw new EmptySQLreturnException("Sorry, the query had no return");
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;	
	}
	
	public static void main(String [] args) {
		Database db = new Database("localhost",5432,"Tripplaner","postgres","tester123");

		try {
			User user = login(db,"Notandi","test123");
			if (user != null) {
				System.out.println(user.getUsername());	
				System.out.println(user.getAge());	
			} else {
				System.out.println("Þetta tokst vist ekki!");
			}
			
		} catch (EmptySQLreturnException e) {
			// TODO Here we need to send the user back to the login screen
			e.printStackTrace();
		}
		
	}
	
	
}
