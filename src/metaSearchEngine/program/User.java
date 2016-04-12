package metaSearchEngine.program;

import java.util.List;

public class User extends UserClass {

	// Data invariant:
	//


	private int age;
	private String hobbies[];
	private String password;
	private boolean admin;
	private List<Package> packages = new List<Package>();
	private final int id;
	private String username;
	private boolean logedIn;
	
	public User(String username, String email, String password, boolean admin, int newId) {
		this.password = password;
		this.id=newId;
		this.admin = admin;
		setUserName(username);
		setEmail(email);
	}
	
	
	public void setUserName(String newUserName){
		if(newUserName.length()>2 && newUserName.length<20 && newUserName.matches("^([a-zA-Z][a-zA-Z0-9]*$") username = newUserName;
		else throw new IllegalArgumentException("Error: Invalid username");
	}

	// Usage: x = setAge(newAge);
	// Before: newAge is an integer 13<newAge<110
	// After: x contains the value of newAge
	static void setAge(int newAge){
		if(newAge<13 || newAge>110) throw new IllegalArgumentException("Error: Invalid age for user. ");
		age = newAge;
	}
	
	// Usage: username = changeUserName(newUserName);
	// Before: Both username and newUserName are Strings
	// 	   of length 3 <= username.length() <= 20 and 
	//	   consist only of numbers and letters and start with a letter
	// After: username has been changed to newUserName
	void setUserName(String newUserName) {
		String userPattern = "^[a-zA-Z]{1}[a-zA-Z0-9]{2,19}";
		
		if (newUserName.matches(userPattern)) {
			this.username = newUserName;
		} else {
			throw new IllegalArgumentException("Error: Username not of legal format.");
		}

	}
	// Usage: email = setEmail(newEmail);
	// Before: Both variables are contain a valid email address.
	// 	  (They might for example match the regular expression
	//	   ^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$ )
	// After: email has been changed to newEmail.
	void setEmail(String newEmail){
		
		String emailPattern = "^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$ )";
		
		if (newEmail.matches(emailPattern)) {
			this.email = newEmail;
		} else {
			throw new IllegalArgumentException("Error: Email not of legal format.");
		}
	}


	void setHobbies(String[] newHobbies){
		hobbies=newHobbies;
	}


	void setPassword(String newPassword, String oldPassword){
		if(password==null) password=newPassword;
		else if(passord==oldPassword) password=newPassword;
		else System.out.println("Wrong password. Password not updated");
	}
	void deleteTrip(Package some_trip){
		packages.remove(some_trip); 
	}

	void addTrip(Package some_trip) {
		packages.add(some_trip);
	}
}
