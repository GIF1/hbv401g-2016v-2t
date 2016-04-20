package metaSearchEngine.program;

// Instances of classes that extend this interface are
// User objects that contain information on customers seeking
// various travel services. 

public interface UserClass {
	//GETTERS
	
	// Usage: username = getUsername();
	// Before: Nothing
	// After: Returns the string username containing the username
	String getUsername();
	
	// Usage: email = getEmail();
	// Before: Nothing
	// After: Returns the string email, containing the users email.
	String getEmail();
	
	// Usage: id = getId();
	// Before: Nothing
	// After: Returns the integer id, containing the users id.
	int getId();
	
	//SETTERS

	// Usage: username = changeUserName(newUserName);
	// Before: Both username and newUserName are Strings
	// 	   of length 3 <= username.length() <= 20 and 
	//	   consist only of numbers and letters and start with a letter
	// After: username has been changed to newUserName
	void setUserName(String newUserName);
	
	// Usage: email = setEmail(newEmail);
	// Before: Both variables are contain a valid email address.
	// 	  (They might for example match the regular expression
	//	   ^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$ )
	// After: email has been changed to newEmail.
	void setEmail(String newEmail);
}
