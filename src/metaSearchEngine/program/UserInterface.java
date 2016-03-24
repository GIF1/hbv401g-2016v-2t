import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class UserInterface {
	//private Flight flightSearchResults;
	//private Hotel hotelSearchResults;
	//private DayTrip dayTripSearchResults;

	void displaySplashScreen() {
		
	}
	
	// Usage: UserInterface.displayLogin();
	// Functionality: Displays user login window and waits for user
	//		to hit the login button. Then it checks for entered
	//		username and password, runs it through the database
	//		and if accepted then overrides attributes in User
	//		class with user information from DB. If it doesn't
	//		accept, an error message will be displayed.
	static void displayLogin() {
		final List<List<String>> userData = new ArrayList<List<String>>();
		final boolean pressedLogin = false;
		
		JFrame frame = new JFrame("Demo application");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		final JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		final JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
		
		ActionListener loginButtonListener = new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				String username = userText.getText();
				String password = passwordText.getText();
				
				// Check database for this username and password.
				// if (database accepts) {
				//		userExists = true;
				//		userData = Database.query(...);
				// else {
				//		userExists = false;
				// }
				
				//Dummy:
				boolean userExists = true;
				List<String> uData = new ArrayList<String>();
				List<String> hobbies = new ArrayList<String>();
				List<String> pressedLogin = new ArrayList<String>();
				
				uData.add(username);
				uData.add("25");
				uData.add("gif1@hi.is");
				uData.add(password);
				uData.add("false");
				
				hobbies.add("Skiing");
				hobbies.add("beach");
				userData.add(uData);
				userData.add(hobbies);
				pressedLogin.add("true");
				userData.add(pressedLogin);
				
				User.setProfile(userData);
			};
		};
		loginButton.addActionListener(loginButtonListener);
		
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog((Component) e.getSource(),
						"button has been pressed");
			}
		});
		
		frame.setVisible(true);
	};
	
	void displayCreateNewUser() {
		
	}
	
	void displayUserProfile() {
		
	}
	
	void displayEditProfile() {
		
	}
	
	void displayResults() {
		
	}
	
	void displayBooking() {
		
	}
	
	void displayPayment() {
		
	}
	
	void displayReceipt() {
		
	}
	
	void displayUserManagement() {
		
	}
	
	/*
	void viewTrip(Packages pacParam) {
		
	}
	
	void login(User loginInfo) {
		// Get username and password:
		// String loginUser = getUsername();
		// String loginPassword = getPassword();
		// Run info through database.
		// If accepted, fetch user info and do following
		
		loginInfo.username = loginUser;
		loginInfo.age = loginAge;
		loginInfo.email = loginEmail;
		loginInfo.hobbies = loginHobbies;
		loginInfo.password = loginPassword;
	}
	*/
	
	public static void main (String[] args) {
		User user = new User();
		user.login();
		
	}
}
