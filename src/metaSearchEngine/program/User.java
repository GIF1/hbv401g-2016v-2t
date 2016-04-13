package metaSearchEngine.program;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public User(int newId, String username, String email, boolean admin) {
		if (newId > 0) {
			this.id = newId;
		} else {
			throw new IllegalArgumentException("Error: Invalid id. ");
		}
		
		setUserName(username);
		setEmail(email);
		this.admin = admin;
	}
	
	// Usage: x = setAge(newAge);
	// Before: newAge is an integer 13<newAge<110
	// After: x contains the value of newAge
	public void setAge(int newAge){
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
		String emailString = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		
		Pattern emailPattern = Pattern.compile(emailString, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(newEmail);
		
		if (matcher.find()) {
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

	public int getAge() {
		return this.age;
	}
	
	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
}
