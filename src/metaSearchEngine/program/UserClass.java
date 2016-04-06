// Instances of classes that extend this interface are
// User objects that contain information on customers seeking
// various travel services. 

public interface UserClass {

	// Minimum attributes all User classes should contain: 
	private String username;
	private String id;	// unique for database usage. 
	private String email;

	// Usage: username = changeUserName(newUserName);
	// Before: Both username and newUserName are Strings
	// 	   of length 3 <= username.length() <= 20 and 
	//	   consist only of numbers and letters and start with a letter
	// After: username has been changed to newUserName
	void changeUserName(String newUserName)

	// Usage: id = setId(newId);
	// Before: newId contains a non-empty string. 
	//	   id could contain null but otherwise a non-empty string
	// After: id has been changed to newId
	
	// Usage: email = setEmail(newEmail);
	// Before: Both variables match the regular expression
	//	   ^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$
	// After: email has been changed to newEmail.
	void setEmail(String newEmail)
}
