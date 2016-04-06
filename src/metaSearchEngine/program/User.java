package metaSearchEngine.program;

import java.util.List;

public class User{
	// Note: Not sure why these attributes are static
	// someone else wrote this - Sigurgeir 06.04
	private static int age;
	private static String hobbies[];
	private static String password;
	private static boolean admin;
	
	public User(String username, int age, String email, String[] hobbies, String password, boolean admin) {
		this.username = username;
		this.age = age;
		this.email = email;
		this.hobbies = hobbies;
		this.password = password;
		this.admin = admin;
	}
	
	// Usage: Used with method getUserInfo in UserInterface class
	void login() {
		UserInterface.displayLogin();
		System.out.println(username);
		// username = "mike";
		// username = userLoggedIn.username;
		// UserInterface.displayLogin();
		// Get username and password from fields
		// loginUsername = 
		//String user = loginVal.username;
	};
	
	// Usage: setProfile(userLoggedIn)
	// Before: userLoggedIn is of type List<List<String>> containing
	//		list of two lists of strings where one contains username, 
	//		age, email, password and admin and the other one contains
	//		hobbies.
	// After: The attributes of the class User have been set
	//		according to user logged in at the moment.
	/*
	static void setProfile(List<List<String>> userLoggedIn) {
		username = userLoggedIn.get(0).get(0);
		age = Integer.parseInt(userLoggedIn.get(0).get(1));
		email = userLoggedIn.get(0).get(2);
		password = userLoggedIn.get(0).get(3);
		admin = Boolean.parseBoolean(userLoggedIn.get(0).get(4));
		hobbies = userLoggedIn.get(1).toArray(new String[0]);
	};
	*/
	
	public void updateUser(User updateParam){
		username = updateParam.username;
	};
	static void setAge(int age){
		
	};
	private void setEmail(String email){
		
	};
	private void setHobbies(String[] hobbies){
		
	};
	private void setPassword(String password){
		
	};
	private void deleteTrip(Package some_trip){
		
	};
}
