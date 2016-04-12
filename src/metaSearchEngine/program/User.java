package metaSearchEngine.program;

import java.util.List;

public class User extends UserClass {

	// Data invariant:
	//


	private int age;
	private String hobbies[];
	private String password;
	private boolean admin=false;
	private List<Package> packages = new List<Package>();
	private final String id;
	private String username;
	private boolean logedIn;
	
	public User(String username, String email, String password, boolean admin) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}
	
	// Usage: Used with method getUserInfo in UserInterface class
	void login() {
		
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

	void setUserName(String newUserName) {
		if(newUserName.length()<3 || newUserName.length()>20) throw new IllegalArgumentException();
		else username=newUserName;

	}

	void setId(String newId){
		if(newId.length()>0) id=newId;
		else throw new IllegalArgumentException();

	}

	void setEmail(String newEmail){
		
		if(newEmail.matches(^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$)) {
			email=newEmail;
		}
		else throw new IllegalArgumentException();
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
