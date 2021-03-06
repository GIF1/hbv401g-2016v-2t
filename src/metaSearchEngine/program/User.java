package metaSearchEngine.program;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements UserClass {

	//Attributes
	private final int id;
	private String username;
	private String email;
	private Integer age = -1;
	private List<Package> packages = null;
	private boolean admin = false;
	
	//Constructor
	public User(int newId, String username, String email, boolean admin) {
		if (verifyId(newId)) {
			this.id = newId;
		} else {
			throw new IllegalArgumentException("Error: Invalid id. ");
		}
		
		setUserName(username);
		setEmail(email);
		this.admin = admin;
	}
	
	
	//VERIFIERS
	
	// Usage: x = verifyId(id);
	// Before: id is an integer
	// After: if id is a legal id, x is true. Else x is false.
	public static boolean verifyId(int id){
			if(id > 0) {
				return true;
			} else {
				return false;
			}	
		}
	

	// Usage: x = verifyAge(age);
	// Before: age is an integer
	// After: if age is a legal age, x is true. Else x is false.
	public static boolean verifyAge(int age){
		if(age < 13 || age > 110) {
			return false;
		} else {
			return true;
		}	
	}
	
	// Usage: x = verifyUsername(username);
	// Before: username is a string
	// After: if username is a legal username, x is true. Else x is false.
	public static boolean verifyUsername(String username) {
		String userPattern = "^[a-zA-Z]{1}[a-zA-Z0-9]{2,19}";
		
		if (username.matches(userPattern)) {
			return true;
		} else {
			return false;
		}
	}
	

	// Usage: x = verifyEmail(Email);
	// Before: Email is a string
	// After: if Email is a legal email, x is true. Else x is false.
	public static boolean verifyEmail(String email) {
		String emailString = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		
		Pattern emailPattern = Pattern.compile(emailString, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(email);
		
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	//SETTERS
	
	// Usage: setAge(newAge);
	// Before: newAge is an integer
	// After: if newAge is a legal age (according to the verifyAge method, the user age attribute is now newAge
	public void setAge(Integer newAge){
		if(verifyAge(newAge)) {
			this.age = newAge;
		} else if (newAge == -1) {
			this.age = newAge;
		}
		else {
			throw new IllegalArgumentException("Error: Invalid age for user. ");
		}	
	}
	
	// Usage: setAdmin(newAdmin);
	// Before: newAdmin is a boolean variable
	// After: The user admin attribute is now newAdmin
	public void setAdmin(boolean newAdmin){
		this.admin = newAdmin;
	}
	
	public void setPackages(List<Package> packages){
		this.packages=packages;
	}
	
	// Usage: setUsername(newUsername);
	// Before: newUsername is a string
	// After: if newUsername is a legal username (according to the verifyUsername method, the user username attribute is now newUsername
	public void setUserName(String newUserName) {
		if (verifyUsername(newUserName)) {
			this.username = newUserName;
		} else {
			throw new IllegalArgumentException("Error: Username not of legal format.");
		}
	}
	
	// Usage: email = setEmail(newEmail);
	// Before: Both variables are contain a valid email address.
	// After: email has been changed to newEmail.
	public void setEmail(String newEmail){
		if (verifyEmail(newEmail)) {
			this.email = newEmail;
		} else {
			throw new IllegalArgumentException("Error: Email not of legal format.");
		}
	}
	
	// GETTERS
	
	// Usage: trip = getTrip();
	// Before: Nothing
	// After: the variable trip contains a list of packages the user has planed to booked.
	public List<Package> getTrip() {
		return this.packages;
	}
	
	// Usage: age = getAge();
	// Before: Nothing
	// After: the variable age contains an integer representing the users age.
	public Integer getAge() {
		return this.age;
	}

	// Usage: isAdmin = getAdmin();
	// Before: Nothing
	// After: the variable idAdmin contains a boolean representing wheter the user is an admin or not.
	public boolean getAdmin() {
		return this.admin;
	}
		
	// Usage: username = getUsername();
	// Before: Nothing
	// After: the variable username contains a string representing the users name.
	@Override
	public String getUsername() {
		return this.username;
	}
	
	// Usage: email = getEmail();
	// Before: Nothing
	// After: the variable email contains a string representing the users email.
	@Override
	public String getEmail() {
		return this.email;
	}
	
	// Usage: id = getId();
	// Before: Nothing
	// After: the variable id contains an integer representing the users id.
	@Override
	public int getId() {
		return this.id;
	}
	
	//MISC
	
	/* Usage: user.deleteTrip(trip)
	 * Pre: trip is an instance of class Package
	 * Post: if trip is in the user list attribute packages, trip has been removed
	 */
	void deleteTrip(Package trip){
		this.packages.remove(trip); 
	}
	
	/* Usage: user.addTrip(trip)
	 * Pre: trip is an instance of class Package
	 * Post: trip has been added to the user list attribute packages
	 */
	void addTrip(Package trip) {
		this.packages.add(trip);
	}
	
	/* Usage: user.addBookingToTrip(booking,packageNr)
	 * Pre: booking is a Booking object and packageNr is an integer.
	 * Post: booking has been added package number packageNr in the user list attribute packages
	 */
	void addBookingToTrip(Booking some_booking, int packageNr) {
		this.packages.get(packageNr).addToTrip(some_booking);
	}
}
