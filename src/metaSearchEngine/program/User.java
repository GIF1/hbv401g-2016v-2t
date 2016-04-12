package metaSearchEngine.program;

public class User implements UserClass {
	private String username;
	private int id;
	private String email;
	private boolean admin;
	
	public User(int id, String user, String email, boolean admin) {
		this.id = id;
		this.admin = admin;
		setUserName(user);
		setEmail(email);
	}
	
	
	 // Usage: username = changeUserName(newUserName);
	// Before: Both username and newUserName are Strings
	// 	   of length 3 <= username.length() <= 20 and 
	//	   consist only of numbers and letters and start with a letter
	// After: username has been changed to newUserName
	public void setUserName(String newUserName){
		String userPattern = "^[a-zA-Z]{1}[a-zA-Z0-9]{2,19}";
		
		if (newUserName.matches(userPattern)) {
			this.username = newUserName;
		} else {
			throw new IllegalArgumentException("Error: Username not of legal format.");
		}
	};
		
	// Usage: email = setEmail(newEmail);
	// Before: Both variables are contain a valid email address.
	// 	  (They might for example match the regular expression
	//	   ^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$ )
	// After: email has been changed to newEmail.
	public void setEmail(String newEmail) {
		String emailPattern = "^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$ )";
		
		if (newEmail.matches(emailPattern)) {
			this.email = newEmail;
		} else {
			throw new IllegalArgumentException("Error: Email not of legal format.");
		}
	};
}
