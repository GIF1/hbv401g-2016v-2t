package metaSearchEngine.program;

import java.util.List;

public class User implements UserClass {
	// Data invariant:
	//
	private final int id;
	private String username;
	private String email;
	private int age;
	private String[] hobbies;
	private List<Package> packages;
	private boolean admin;
	
	public User(int newId, String username, String email) {
		if (newId > 0) {
			this.id = newId;
		} else {
			throw new IllegalArgumentException("Error: Invalid id. ");
		}
		
		setUserName(username);
		setEmail(email);
	}
	
	// Usage: x = setAge(newAge);
	// Before: newAge is an integer 13<newAge<110
	// After: x contains the value of newAge
	void setAge(int newAge){
		if(newAge<13 || newAge>110) {
			throw new IllegalArgumentException("Error: Invalid age for user. ");
		} else {
			this.age = newAge;
		}	
	}
	
	// Usage: username = changeUserName(newUserName);
	// Before: Both username and newUserName are Strings
	// 	   of length 3 <= username.length() <= 20 and 
	//	   consist only of numbers and letters and start with a letter
	// After: username has been changed to newUserName
	public void setUserName(String newUserName) {
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
	public void setEmail(String newEmail){
		String emailPattern = "^([\\w−] + (? : \\.[\\w−]+)*)@((? : [\\w−] + \\.)*\\w[\\w−]0, 66)\\.([a − z]2, 6(? : \\.[a − z]2)?)$ )";
		
		if (newEmail.matches(emailPattern)) {
			this.email = newEmail;
		} else {
			throw new IllegalArgumentException("Error: Email not of legal format.");
		}
	}

	void setHobbies(String[] newHobbies){
		hobbies = newHobbies;
	}
	
	void deleteTrip(Package some_trip){
		packages.remove(some_trip); 
	}

	void addTrip(Package some_trip) {
		packages.add(some_trip);
	}
}
