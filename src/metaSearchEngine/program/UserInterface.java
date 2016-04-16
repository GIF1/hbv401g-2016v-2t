package metaSearchEngine.program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;

import org.eclipse.AutoCompletion;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.postgresql.util.PSQLException;

import java.awt.Component;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.UIManager;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;

import metaSearchEngine.mockobjects.FlightExtend;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import com.toedter.calendar.JDayChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseMotionAdapter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JPasswordField;

public class UserInterface {

	private JFrame frmMetaSearchEngine;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JComboBox<String> txtDepLoc;
	private JDateChooser depTime;
	private JComboBox<String> txtArrLoc;
	private JComboBox<String> txtSeatClass;
	private JRadioButton rdbtnRoundTripYes;
	private JTextField txtLowerPriceBound;
	private JTextField txtHigherPriceBound;
	private JTextField txtNrSeats;
	private final ButtonGroup btnGroupRndTrip = new ButtonGroup();
	//private final ButtonGroup btnGroupOverlay = new ButtonGroup();
	private JComboBox<String> txtHotelLoc;
	private JTextField txtNewUsername;
	private JTextField txtNewPass;
	private JTextField txtConPass;
	private JTextField txtNewEmail;
	
	// Fields for Day trip search criteria
	private JTextField txtNumParti;
	private JTextField txtLowerPrice;
	private JTextField txtHigherPrice;
	
	private JTable tabFlightResults;
	private JTable tabDaytripResults;
	
	// Card container for the main frame
	// Cards to be children here are Login, 
	// CreateNewUser, SplashScreen, Booking,
	// UserProfile, EditProfile and UserManagement
	JPanel CardContainer = new JPanel();
	CardLayout mainLayout = new CardLayout();
	
	// Card container for the search criteria
	// Cards to be children here are FlightSearchCriteria,
	// HotelSearchCriteria, DaytripSearchCriteria
	JPanel SearchCriteria = new JPanel();
	CardLayout searchLayout = new CardLayout();
	
	// Card container for the search result table
	// Cards to be children here are FlightResults,
	// HotelResults and DaytripResults
	JPanel SearchResults = new JPanel();
	CardLayout resultLayout = new CardLayout();
	
	
	JPanel Booking = new JPanel();
	CardLayout bookingLayout = new CardLayout();
	
	JPanel BookingDisplay = new JPanel();
	CardLayout bookingDispLayout = new CardLayout();
	
	User userLoggedIn = null;
	
	Database db = new Database("localhost",5432,"Tripplaner","postgres","tester123");

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmMetaSearchEngine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.

	public UserInterface() {
		initialize();
	}

	// Initialize the contents of the frame.

	private void initialize() {
		frmMetaSearchEngine = new JFrame();
		frmMetaSearchEngine.setTitle("Meta Search Engine");
		frmMetaSearchEngine.setBounds(100, 100, 1140, 610);
		frmMetaSearchEngine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMetaSearchEngine.getContentPane().setLayout(null);
		
		// Setting up main layout CardContainer
		CardContainer.setBounds(0, 0, 1122, 563);
		frmMetaSearchEngine.getContentPane().add(CardContainer);
		CardContainer.setLayout(mainLayout);
		
		// Setting up Login screen
		displayLogin();
		
	}
	
	private void displayLogin() {
		JPanel Login = new JPanel();
		CardContainer.add(Login, "Login");
		Login.setLayout(null);
		mainLayout.show(CardContainer, "Login");
		
		JLabel lblTitle = new JLabel("Welcome to Meta Search Engine");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblTitle.setBounds(331, 13, 460, 50);
		Login.add(lblTitle);
		
		JLabel lblSignIn = new JLabel("- Sign in and enjoy the benefits");
		lblSignIn.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		lblSignIn.setBounds(492, 63, 272, 23);
		Login.add(lblSignIn);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(431, 126, 95, 20);
		Login.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(530, 125, 180, 24);
		Login.add(txtUsername);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(435, 170, 95, 26);
		Login.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(530, 170, 180, 24);
		Login.add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setForeground(Color.GRAY);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if legal name and password
				// if so, search through the database if
				// it matches any user
				// if so, open main screen with an instance
				// of the user class.
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				try {
					userLoggedIn = db.login(username, password);
				} catch (EmptySQLreturnException databaseError) {
					// TODO Auto-generated catch block
					//System.out.println("Error");
					databaseError.printStackTrace();
				}
				if (userLoggedIn != null) {
					displayHomeScreen();
				} else {
					System.out.println("Username or password incorrect");
				}
			}
		});
		btnSignIn.setBounds(431, 220, 125, 30);
		Login.add(btnSignIn);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSignUp = new JButton("New User");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCreateNewUser();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUp.setBounds(585, 220, 125, 30);
		Login.add(btnSignUp);
	}
	
	private void displayCreateNewUser() {
		JPanel SignUp = new JPanel();
		CardContainer.add(SignUp, "SignUp");
		SignUp.setLayout(null);
		mainLayout.show(CardContainer, "SignUp");
		
		JLabel lblNewUsername = new JLabel("Username:");
		lblNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewUsername.setBounds(427, 141, 85, 20);
		SignUp.add(lblNewUsername);
		
		txtNewUsername = new JTextField();
		txtNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNewUsername.setBounds(512, 139, 160, 25);
		SignUp.add(txtNewUsername);
		txtNewUsername.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPassword.setBounds(432, 176, 80, 20);
		SignUp.add(lblNewPassword);
		
		txtNewPass = new JTextField();
		txtNewPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNewPass.setBounds(512, 174, 160, 25);
		SignUp.add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(380, 211, 120, 20);
		SignUp.add(lblConfirmPassword);
		
		txtConPass = new JTextField();
		txtConPass.setBounds(512, 209, 160, 25);
		SignUp.add(txtConPass);
		txtConPass.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(460, 245, 52, 20);
		SignUp.add(lblEmail);
		
		txtNewEmail = new JTextField();
		txtNewEmail.setBounds(512, 245, 160, 25);
		SignUp.add(txtNewEmail);
		txtNewEmail.setColumns(10);
		
		JLabel lblNewUser = new JLabel("Create New User");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewUser.setBounds(460, 98, 181, 30);
		SignUp.add(lblNewUser);
		
		JButton btnSignUp_1 = new JButton("Sign Up...");
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPassword = txtNewPass.getText();
				User newUser = null;
				if (txtNewPass.getText().equals(txtConPass.getText())) {
					String newUsername = txtNewUsername.getText();
					String newEmail = txtNewEmail.getText();
					
					try {
						newUser = db.createUser(newUsername, newPassword, newEmail, false, null);
					} catch (EmptySQLreturnException databaseError) {
						// TODO Auto-generated catch block
						//System.out.println("Error");
						databaseError.printStackTrace();
					}
					
					if (newUser != null) {
						userLoggedIn = newUser;
						displayHomeScreen();
					}
				} else {
					System.out.println("Passwords do not match");
				}
			}
		});
		btnSignUp_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp_1.setBounds(470, 283, 150, 30);
		SignUp.add(btnSignUp_1);
		
		JLabel lblorGoHome = new JLabel("...or go home");
		lblorGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				displayLogin();
			}
		});
		lblorGoHome.setBounds(535, 318, 85, 25);
		SignUp.add(lblorGoHome);
		
		JLabel lblSignupHead = new JLabel("Be a member of the MSE family");
		lblSignupHead.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblSignupHead.setBounds(348, 13, 470, 50);
		SignUp.add(lblSignupHead);
		
		JLabel lblAndNever = new JLabel("... and never lose the cool!");
		lblAndNever.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		lblAndNever.setBounds(558, 62, 220, 23);
		SignUp.add(lblAndNever);
	}
	
	private void displayHomeScreen() {
		JPanel SplashScreen = new JPanel();
		CardContainer.add(SplashScreen, "SplashScreen");
		SplashScreen.setLayout(null);
		mainLayout.show(CardContainer, "SplashScreen");
		
		
		// Setting up SearchCriteria cards
		SearchCriteria.setBounds(25, 76, 390, 437);
		SplashScreen.add(SearchCriteria);
		SearchCriteria.setLayout(searchLayout);
		
		// Setting up Result Table cards
		SearchResults.setBounds(443, 76, 667, 437);
		SplashScreen.add(SearchResults);
		SearchResults.setLayout(resultLayout);
		JScrollPane scrollPaneEmpty = new JScrollPane();
		SearchResults.add(scrollPaneEmpty, "emptyTable");
		resultLayout.show(SearchResults,"emptyTable");
		
		// Setting up Flight search criteria button
		final JButton btnFlightSearch = new JButton("Flight Search");
		btnFlightSearch.setBounds(15, 13, 120, 40);
		SplashScreen.add(btnFlightSearch);
		btnFlightSearch.setBackground(UIManager.getColor("Button.background"));
		displayFlightSC();

		btnFlightSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLayout.show(SearchResults,"emptyTable");
				displayFlightSC();
			}
		});
		
		// Setting up Hotel search criteria button
		final JButton btnHotelSearch = new JButton("Hotel Search");
		btnHotelSearch.setBounds(155, 13, 120, 40);
		SplashScreen.add(btnHotelSearch);
		btnHotelSearch.setBackground(UIManager.getColor("Button.background"));

		btnHotelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLayout.show(SearchResults,"emptyTable");
				displayHotelSC();
			}
		});
		
		// Setting up Daytrip search criteria button
		final JButton btnDaytripSearch = new JButton("Daytrip Search");
		btnDaytripSearch.setBounds(295, 13, 120, 40);
		SplashScreen.add(btnDaytripSearch);
		btnDaytripSearch.setBackground(UIManager.getColor("Button.background"));

		btnDaytripSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLayout.show(SearchResults,"emptyTable");
				displayDaytripSC();
			}
		});
		
		// User functionality
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLoggedIn = null;
				displayLogin();
			}
		});
		btnNewButton.setBounds(1013, 13, 97, 25);
		SplashScreen.add(btnNewButton);
		
		JLabel lblUserLoggedIn = new JLabel(userLoggedIn.getUsername(), SwingConstants.RIGHT);
		lblUserLoggedIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserLoggedIn.setBounds(785, 13, 97, 22);
		SplashScreen.add(lblUserLoggedIn);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayEditProfile();
			}
		});
		btnEditProfile.setBounds(906, 13, 97, 25);
		SplashScreen.add(btnEditProfile);
	}
	
	private void displayFlightSC() {
		JPanel FlightSearch = new JPanel();
		SearchCriteria.add(FlightSearch, "FlightSearch");
		FlightSearch.setLayout(null);
		searchLayout.show(SearchCriteria,"FlightSearch");
		
		JLabel lblFlightSearch = new JLabel("Flight Search");
		lblFlightSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlightSearch.setBounds(140, 13, 109, 22);
		FlightSearch.add(lblFlightSearch);
		
		// Departure location
		JLabel lblDepLocation = new JLabel("Dep. Location:");
		lblDepLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepLocation.setBounds(12, 55, 100, 16);
		FlightSearch.add(lblDepLocation);
		
		txtDepLoc = new JComboBox<String>();
		txtDepLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"Akureyri", "Egilsstaðir", "Reykjavík"}));
		AutoCompletion.enable(txtDepLoc);
		txtDepLoc.setEditable(true);
		txtDepLoc.setBounds(112, 53, 240, 22);
		FlightSearch.add(txtDepLoc);
		
		// Arrival location
		JLabel lblArrLocation = new JLabel("Arr. Location:");
		lblArrLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArrLocation.setBounds(12, 90, 100, 16);
		FlightSearch.add(lblArrLocation);
		
		txtArrLoc = new JComboBox<String>();
		txtArrLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"Akureyri", "Egilsstaðir", "Reykjavík"}));
		AutoCompletion.enable(txtArrLoc);
		txtArrLoc.setEditable(true);
		txtArrLoc.setBounds(112, 87, 240, 22);
		FlightSearch.add(txtArrLoc);
		
		// Departure time 
		JLabel lblDepTime = new JLabel("Dep. Time:");
		lblDepTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepTime.setBounds(12, 125, 100, 16);
		FlightSearch.add(lblDepTime);
		
		depTime = new JDateChooser();
		depTime.setBounds(112, 119, 240, 22);
		FlightSearch.add(depTime);
		
		// Number of seats needed
		JLabel lblNrSeats = new JLabel("Nr. Seats:");
		lblNrSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNrSeats.setBounds(12, 160, 90, 16);
		FlightSearch.add(lblNrSeats);
		
		txtNrSeats = new JTextField();
		txtNrSeats.setText("1");
		txtNrSeats.setBounds(111, 157, 60, 22);
		FlightSearch.add(txtNrSeats);
		txtNrSeats.setColumns(10);
		
		// Seatclass combobox
		JLabel lblSeatClass = new JLabel("Class:");
		lblSeatClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeatClass.setBounds(12, 195, 100, 16);
		FlightSearch.add(lblSeatClass);
		
		txtSeatClass = new JComboBox<String>();
		txtSeatClass.setModel(new DefaultComboBoxModel<String>(new String[] {"Economy", "Business"}));
		txtSeatClass.setBounds(112, 192, 131, 22);
		FlightSearch.add(txtSeatClass);
		
		// Return trip, radio button
		JLabel lblReturnTrip = new JLabel("Return Trip:");
		lblReturnTrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnTrip.setBounds(12, 230, 83, 22);
		FlightSearch.add(lblReturnTrip);
		
		JRadioButton rdbtnRoundTripNo = new JRadioButton("No");
		btnGroupRndTrip.add(rdbtnRoundTripNo);
		rdbtnRoundTripNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnRoundTripNo.setBounds(177, 229, 61, 25);
		FlightSearch.add(rdbtnRoundTripNo);
		
		rdbtnRoundTripYes = new JRadioButton("Yes");
		btnGroupRndTrip.add(rdbtnRoundTripYes);
		rdbtnRoundTripYes.setSelected(true);
		rdbtnRoundTripYes.setBounds(112, 229, 61, 25);
		FlightSearch.add(rdbtnRoundTripYes);
		
		// Optional label
		JLabel lblOptional = new JLabel("Optional");
		lblOptional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOptional.setBounds(161, 278, 83, 25);
		FlightSearch.add(lblOptional);
		
		// Price range textboxes
		JLabel lblPriceRange = new JLabel("Price Range:");
		lblPriceRange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceRange.setBounds(12, 311, 100, 18);
		FlightSearch.add(lblPriceRange);
		
		txtLowerPriceBound = new JTextField();
		txtLowerPriceBound.setBounds(112, 310, 100, 22);
		FlightSearch.add(txtLowerPriceBound);
		txtLowerPriceBound.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(205, 313, 49, 16);
		FlightSearch.add(label);
		
		txtHigherPriceBound = new JTextField();
		txtHigherPriceBound.setBounds(251, 310, 101, 22);
		FlightSearch.add(txtHigherPriceBound);
		txtHigherPriceBound.setColumns(10);
		
		// Search button definition
		JButton btnSearchFlight = new JButton("Search");
		btnSearchFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchFlight.setBounds(109, 386, 185, 38);
		FlightSearch.add(btnSearchFlight);
		
		// Search button action listener.
		// When pressed the data from above defined fields is gathered
		// and put into a new instance of the FlightSearchCriteria 
		// class with its set methods. Then a method from the flight
		// search engine is called to search for flight matching the
		// criteria. That returns a list of flight classes each class
		// representing one flight. This list is feed to the 
		// displayFlightResults method in the UserInterface to display
		// a table of the list.
		btnSearchFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightSearchCriteria newFlightSearch = new FlightSearchCriteria();
				newFlightSearch.setDepartureLoc((String) txtDepLoc.getSelectedItem());
				newFlightSearch.setArrivalLoc((String) txtArrLoc.getSelectedItem());
				newFlightSearch.setDepartureTime(depTime.getDate());
				newFlightSearch.setNumSeats(Integer.parseInt(txtNrSeats.getText()));
				newFlightSearch.setSeatClass((String)txtSeatClass.getSelectedItem());
				newFlightSearch.setReturnTrip(rdbtnRoundTripYes.isSelected());
				
				// Optional
				int lowerBound = 0;
				int higherBound = 999999;
				if (!(txtLowerPriceBound.getText().equals(""))) {
					lowerBound = Integer.parseInt(txtLowerPriceBound.getText());
				}
				if (!(txtHigherPriceBound.getText().equals(""))) {
					higherBound = Integer.parseInt(txtHigherPriceBound.getText());
				}
				newFlightSearch.setPriceRange(new int[]{lowerBound,higherBound});
				
				List<FlightAbstract> flightResults = SearchEngine.flightSearch(newFlightSearch);
				
				if (flightResults.size() == 0) {
					System.out.println("Unfortunately no flights were found");
				} else if (flightResults.size() > 0) {
					// Display list of results
					displayFlightResults(flightResults);
				}
			}
		});
	}
	
	private void displayFlightResults(final List<FlightAbstract> flightResults) {
		JScrollPane scrollPaneFlight = new JScrollPane();
		SearchResults.add(scrollPaneFlight, "FlightResults");
		resultLayout.show(SearchResults,"FlightResults");
		
		tabFlightResults = new JTable();
		tabFlightResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tabFlightResults.clearSelection();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tabFlightResults.rowAtPoint(e.getPoint());
				//User userLoggedIn = new User(1,"Gunnar","gif1@hi.is",false);
				//FlightBooking flightToBook = new FlightBooking(flightResults.get(row),1,userLoggedIn);
				//System.out.println(flightResults.get(3).get_depLoc());
				displayFlightBooking(flightResults.get(row));
			}
		});
		tabFlightResults.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = tabFlightResults.rowAtPoint(e.getPoint());
				if (row > -1) {
					tabFlightResults.clearSelection();
					tabFlightResults.setRowSelectionInterval(row,row);
				}
			}
		});
		
		Object[][] flights = new Object[flightResults.size()][7];
		for (int i=0; i<flightResults.size(); i++) {
			FlightAbstract flight = flightResults.get(i);
			flights[i][0] = flight.get_dealerInfo()[0];
			flights[i][1] = flight.get_depTime();
			flights[i][2] = flight.get_depLoc();
			flights[i][3] = "-";
			flights[i][4] = flight.get_arrTime();
			flights[i][5] = flight.get_arrivLoc();
			flights[i][6] = flight.get_price();
		}
		String[] columns = new String[] {
				"Airline", "Dep. Time", "Dep. Location", "To", "Arr. Time", "Arr. Location", "Price"
		};
		
		tabFlightResults.setSurrendersFocusOnKeystroke(true);
		tabFlightResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabFlightResults.setModel(new DefaultTableModel(flights,columns));
		
		tabFlightResults.getColumnModel().getColumn(2).setPreferredWidth(90);
		tabFlightResults.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabFlightResults.getColumnModel().getColumn(5).setPreferredWidth(85);
		tabFlightResults.getColumnModel().getColumn(6).setPreferredWidth(65);
		scrollPaneFlight.setViewportView(tabFlightResults);
	}
	
	private void displayFlightBooking(FlightAbstract flightToBook) {
		User userLoggedIn = new User(1,"Gunnar","gif1@hi.is",false);
		FlightBooking flightBooking = new FlightBooking(flightToBook,1,userLoggedIn);
		
		CardContainer.add(Booking, "Booking");
		mainLayout.show(CardContainer, "Booking");
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(1013, 13, 97, 25);
		Booking.add(btnLogOut);
		
		JLabel lblUserLoggedIn2 = new JLabel("User logged in");
		lblUserLoggedIn2.setBounds(785, 13, 97, 22);
		Booking.add(lblUserLoggedIn2);
		lblUserLoggedIn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditProfile_1 = new JButton("Edit Profile");
		btnEditProfile_1.setBounds(906, 13, 97, 25);
		Booking.add(btnEditProfile_1);
		
		BookingDisplay = new JPanel();
		BookingDisplay.setBounds(0, 60, 1110, 503);
		Booking.add(BookingDisplay);
		
		JPanel FlightBooking = new JPanel();
		BookingDisplay.add(FlightBooking, "FlightBooking");
		BookingDisplay.setLayout(bookingDispLayout);
		bookingDispLayout.show(BookingDisplay, "FlightBooking");
		
		JLabel lblFlightBooking = new JLabel("Flight Booking");
		lblFlightBooking.setBounds(460, 13, 202, 34);
		lblFlightBooking.setFont(new Font("Tahoma", Font.BOLD, 28));
		FlightBooking.add(lblFlightBooking);
		
		JPanel FlightBookingCards = new JPanel();
		CardLayout flightBookingLayout = new CardLayout();
		FlightBookingCards.setBounds(12, 67, 1098, 436);
		FlightBooking.add(FlightBookingCards);
		FlightBookingCards.setLayout(flightBookingLayout);
		
		JPanel FlightBookingConfig = new JPanel();
		FlightBookingCards.add(FlightBookingConfig, "FlightBookingConfig");
		flightBookingLayout.show(FlightBookingCards, "FlightBookingConfig");
		
		JLabel lblSelectFromAvailable = new JLabel("Select from available seats:");
		lblSelectFromAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectFromAvailable.setBounds(50, 13, 200, 22);
		FlightBookingConfig.add(lblSelectFromAvailable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 12, 84, 88);
		FlightBookingConfig.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"11A", "11B", "12C", "14F", "11A", "11B", "12C", "14F"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblSeatsChosen = new JLabel("Seats chosen:");
		lblSeatsChosen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeatsChosen.setBounds(50, 134, 110, 22);
		FlightBookingConfig.add(lblSeatsChosen);
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setCellSelectionEnabled(true);
		table.setBounds(50, 169, 300, 32);
		FlightBookingConfig.add(table);
	}
	
	private void displayHotelSC() {
		JPanel HotelSearch = new JPanel();
		SearchCriteria.add(HotelSearch, "HotelSearch");
		HotelSearch.setLayout(null);
		searchLayout.show(SearchCriteria,"HotelSearch");
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(12, 54, 100, 17);
		HotelSearch.add(lblLocation);
		
		JLabel lblHotelSearch = new JLabel("Hotel Search");
		lblHotelSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHotelSearch.setBounds(140, 13, 109, 22);
		HotelSearch.add(lblHotelSearch);
		
		txtHotelLoc = new JComboBox<String>();
		txtHotelLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"Reykjavík", "Akureyri"}));
		AutoCompletion.enable(txtHotelLoc);
		txtHotelLoc.setEditable(true);
		txtHotelLoc.setBounds(112, 53, 240, 22);
		HotelSearch.add(txtHotelLoc);
		
		JDateChooser dateCheckin = new JDateChooser();
		dateCheckin.setBounds(12, 120, 150, 22);
		HotelSearch.add(dateCheckin);
		
		JLabel lblCheckIn = new JLabel("Check in");
		lblCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckIn.setBounds(12, 95, 60, 16);
		HotelSearch.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("Check out");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckOut.setBounds(201, 95, 71, 16);
		HotelSearch.add(lblCheckOut);
		
		JDateChooser dateCheckOut = new JDateChooser();
		dateCheckOut.setBounds(201, 120, 150, 22);
		HotelSearch.add(dateCheckOut);
		
		JButton btnSearchHotel = new JButton("Search");
		btnSearchHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check if data is acceptable
				// if acceptable create HotelSearchCriteria
				// Search for hotels and call result display
			}
		});
		btnSearchHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchHotel.setBounds(109, 200, 185, 38);
		HotelSearch.add(btnSearchHotel);
	}
	
	private void displayDaytripSC() {
		JPanel DaytripSearch = new JPanel();
		SearchCriteria.add(DaytripSearch, "DaytripSearch");
		DaytripSearch.setLayout(null);
		searchLayout.show(SearchCriteria,"DaytripSearch");
		
		JLabel lblDayTripSearch = new JLabel("Day Trip Search");
		lblDayTripSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDayTripSearch.setBounds(125, 13, 135, 22);
		DaytripSearch.add(lblDayTripSearch);
		
		JLabel lblNameOfTrip = new JLabel("Name of trip:");
		lblNameOfTrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameOfTrip.setBounds(12, 55, 80, 16);
		DaytripSearch.add(lblNameOfTrip);
		
		final JComboBox<String> txtNameOfTrip = new JComboBox<String>();
		txtNameOfTrip.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Golden circle", "Mount climbing on Arnarhóll", "Northen lights maniacs"}));
		txtNameOfTrip.setEditable(true);
		txtNameOfTrip.setBounds(112, 53, 240, 22);
		DaytripSearch.add(txtNameOfTrip);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategory.setBounds(12, 90, 80, 18);
		DaytripSearch.add(lblCategory);
		
		final JComboBox<String> txtCategory = new JComboBox<String>();
		txtCategory.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Romantic", "Extreme", "Chill", "Insane"}));
		txtCategory.setEditable(true);
		txtCategory.setBounds(112, 88, 240, 22);
		DaytripSearch.add(txtCategory);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(12, 126, 80, 16);
		DaytripSearch.add(lblLocation);
		
		final JComboBox<String> txtLocation = new JComboBox<String>();
		txtLocation.setEditable(true);
		txtLocation.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Akureyri", "Egilsstaðir", "Reykjavík"}));
		txtLocation.setBounds(112, 124, 240, 22);
		DaytripSearch.add(txtLocation);
		
		JLabel lblNrParti = new JLabel("Nr. of Trippers:");
		lblNrParti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNrParti.setBounds(12, 221, 100, 16);
		DaytripSearch.add(lblNrParti);
		
		txtNumParti = new JTextField();
		txtNumParti.setText("1");
		txtNumParti.setBounds(112, 218, 60, 22);
		DaytripSearch.add(txtNumParti);
		txtNumParti.setColumns(10);
		
		JLabel lblTimeFrame = new JLabel("Time frame:");
		lblTimeFrame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeFrame.setBounds(12, 179, 83, 16);
		DaytripSearch.add(lblTimeFrame);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setBounds(112, 159, 67, 16);
		DaytripSearch.add(lblStartTime);
		
		final JDateChooser dateStartTime = new JDateChooser();
		dateStartTime.setBounds(112, 179, 76, 22);
		DaytripSearch.add(dateStartTime);
		
		JLabel label_1 = new JLabel("-");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(206, 180, 26, 16);
		DaytripSearch.add(label_1);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setBounds(231, 159, 67, 16);
		DaytripSearch.add(lblEndTime);
		
		final JDateChooser dateEndTime = new JDateChooser();
		dateEndTime.setBounds(231, 179, 76, 22);
		DaytripSearch.add(dateEndTime);
		
		JLabel lblPriceRangeDay = new JLabel("Price Range:");
		lblPriceRangeDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceRangeDay.setBounds(12, 259, 100, 18);
		DaytripSearch.add(lblPriceRangeDay);
		
		txtLowerPrice = new JTextField();
		txtLowerPrice.setColumns(10);
		txtLowerPrice.setBounds(112, 256, 100, 22);
		DaytripSearch.add(txtLowerPrice);
		
		JLabel label_2 = new JLabel("-");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(205, 259, 49, 16);
		DaytripSearch.add(label_2);
		
		txtHigherPrice = new JTextField();
		txtHigherPrice.setColumns(10);
		txtHigherPrice.setBounds(251, 256, 101, 22);
		DaytripSearch.add(txtHigherPrice);
		
		JButton btnSearchDaytrip = new JButton("Search");
		btnSearchDaytrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check if data is acceptable
				// if acceptable create HotelSearchCriteria
				// Search for hotels and call result display
				DayTripSearchCriteria newDaytripSearch = new DayTripSearchCriteria();
				if (!(txtNameOfTrip.getSelectedItem().equals(""))) {
					newDaytripSearch.setName((String) txtNameOfTrip.getSelectedItem());
				} else {
					newDaytripSearch.setName(null);
				}
				if (!(txtCategory.getSelectedItem().equals(""))) {
					newDaytripSearch.setCategory((String) txtCategory.getSelectedItem());
				} else {
					newDaytripSearch.setCategory(null);
				}
				if (!(txtCategory.getSelectedItem().equals(""))) {
					newDaytripSearch.setLocation((String) txtLocation.getSelectedItem());
				} else {
					newDaytripSearch.setLocation(null);
				}
				
				newDaytripSearch.setStartTime(dateStartTime.getDate());
				newDaytripSearch.setEndTime(dateEndTime.getDate());
				
				int numParti = 0;
				try {
					numParti = Integer.parseInt(txtNumParti.getText());
				} catch(NumberFormatException exc) {
					numParti = -1;
				}
				newDaytripSearch.setNumParticipants(numParti);
				
				int lowerBound = 0;
				int higherBound = 0;
				try {
					lowerBound = Integer.parseInt(txtLowerPrice.getText());
				} catch(NumberFormatException exc) {
					lowerBound = -1;
				}
				try {
					higherBound = Integer.parseInt(txtHigherPrice.getText());
				} catch(NumberFormatException exc) {
					higherBound = -1;
				}
				newDaytripSearch.setPriceRange(new int[]{lowerBound,higherBound});
				
				List<DaytripAbstract> daytripResults = SearchEngine.daytripSearch(newDaytripSearch);
				
				if (daytripResults.size() == 0) {
					System.out.println("Unfortunately no day trips were found");
				} else if (daytripResults.size() > 0) {
					// Display list of results
					displayDaytripResults(daytripResults);
				}
			}
		});
		btnSearchDaytrip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchDaytrip.setBounds(109, 291, 185, 38);
		DaytripSearch.add(btnSearchDaytrip);
	}
	
	private void displayDaytripResults(final List<DaytripAbstract> daytripResults) {
		JScrollPane scrollPaneDaytrip = new JScrollPane();
		SearchResults.add(scrollPaneDaytrip, "DaytripResults");
		resultLayout.show(SearchResults, "DaytripResults");
		
		tabDaytripResults = new JTable();
		tabDaytripResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tabDaytripResults.clearSelection();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tabDaytripResults.rowAtPoint(e.getPoint());
				//User userLoggedIn = new User(1,"Gunnar","gif1@hi.is",false);
				//FlightBooking flightToBook = new FlightBooking(flightResults.get(row),1,userLoggedIn);
				//System.out.println(flightResults.get(3).get_depLoc());
				displayDaytripBooking(daytripResults.get(row));
			}
		});
		
		tabDaytripResults.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = tabDaytripResults.rowAtPoint(e.getPoint());
				if (row > -1) {
					tabDaytripResults.clearSelection();
					tabDaytripResults.setRowSelectionInterval(row,row);
				}
			}
		});
		
		Object[][] daytrips = new Object[daytripResults.size()][6];
		for (int i=0; i<daytripResults.size(); i++) {
			DaytripAbstract daytrip = daytripResults.get(i);
			daytrips[i][0] = daytrip.getDealerInfo()[0];
			daytrips[i][1] = daytrip.getCategory();
			daytrips[i][2] = daytrip.getLocation();
			daytrips[i][3] = daytrip.getStartTime();
			daytrips[i][4] = daytrip.getEndTime();
			daytrips[i][5] = daytrip.getPrice();
		}
		String[] columns = new String[] {
				"Organizer", "Type", "Location", "Go time", "Return time", "Price"
		};
		
		tabDaytripResults.setSurrendersFocusOnKeystroke(true);
		tabDaytripResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabDaytripResults.setModel(new DefaultTableModel(daytrips,columns));
		
		scrollPaneDaytrip.setViewportView(tabDaytripResults);
	}
	
	private void displayDaytripBooking(DaytripAbstract daytripToBook) {
		System.out.println(daytripToBook.getCategory());
	}
	
	private void displayEditProfile() {
		JPanel EditUser = new JPanel();
		CardContainer.add(EditUser, "EditUser");
		EditUser.setLayout(null);
		mainLayout.show(CardContainer, "EditUser");
		
		JLabel Heading = new JLabel("Define yourself");
		Heading.setBounds(10, 11, 1102, 59);
		Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		EditUser.add(Heading);
		
		final JTextField editUserUsername = new JTextField();
		editUserUsername.setBounds(537, 125, 200, 20);
		editUserUsername.setText(userLoggedIn.getUsername());
		EditUser.add(editUserUsername);
		editUserUsername.setColumns(10);
		
		final JTextField editUserPassword = new JTextField();
		editUserPassword.setBounds(537, 175, 200, 20);
		EditUser.add(editUserPassword);
		editUserPassword.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername_1.setBounds(460, 124, 67, 19);
		EditUser.add(lblUsername_1);
		
		JLabel lblPassword_1 = new JLabel("New Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword_1.setBounds(460, 174, 67, 19);
		EditUser.add(lblPassword_1);
		
		JLabel lblConfirmPassword_1 = new JLabel("Confirm password");
		lblConfirmPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword_1.setBounds(411, 227, 116, 19);
		EditUser.add(lblConfirmPassword_1);
		
		final JTextField editUserConfirmPassword = new JTextField();
		editUserConfirmPassword.setColumns(10);
		editUserConfirmPassword.setBounds(537, 228, 200, 20);
		EditUser.add(editUserConfirmPassword);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(502, 330, 25, 19);
		EditUser.add(lblAge);
		
		final JTextField editUserAge = new JTextField();
		editUserAge.setColumns(10);
		editUserAge.setBounds(537, 331, 200, 20);
		editUserAge.setText(Integer.toString(userLoggedIn.getAge()));
		EditUser.add(editUserAge);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail_1.setBounds(494, 280, 33, 19);
		EditUser.add(lblEmail_1);
		
		final JTextField editUserEmail = new JTextField();
		editUserEmail.setColumns(10);
		editUserEmail.setBounds(537, 281, 200, 20);
		editUserEmail.setText(userLoggedIn.getEmail());
		EditUser.add(editUserEmail);
		
		JButton editUserSaveChanges = new JButton("Save Changes");
		editUserSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here we are saving the changes!
				String newUsername = editUserUsername.getText();
				String newPassword = null;
				if (editUserPassword.getText().equals(editUserConfirmPassword.getText())) {
					newPassword = editUserPassword.getText();
				} else {
					System.out.println("Password not successfully updated. Confirm password did not match.");
				}
				String newEmail = editUserEmail.getText();
				Boolean newAdmin = null;
				Integer newAge = null;
				try {
					newAge = Integer.parseInt(editUserAge.getText());
				} catch (NumberFormatException exc) {
					System.out.println("Age containes illegal input");
				}
				List<Package> newPackages = null;
				
				userLoggedIn = db.editUser(userLoggedIn, newUsername, newPassword, newEmail, newAdmin, newAge, newPackages);
			}
		});
		editUserSaveChanges.setBackground(Color.GREEN);
		editUserSaveChanges.setBounds(460, 406, 116, 23);
		EditUser.add(editUserSaveChanges);
		
		JButton editUserCancel = new JButton("Cancel");
		editUserCancel.setBackground(Color.RED);
		editUserCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayHomeScreen();
			}
		});
		editUserCancel.setBounds(621, 406, 116, 23);
		EditUser.add(editUserCancel);
	}
}

/*
public class UserInterface {

	private JFrame frmMetaSearchEngine;
	private JTextField txtUsername;
	private JTextField txtLowerPriceBound;
	private JTextField txtHigherPriceBound;
	private JTextField txtNrSeats;
	private final ButtonGroup btnGroupRndTrip = new ButtonGroup();
	private final ButtonGroup btnGroupOverlay = new ButtonGroup();
	private JTextField txtNewUsername;
	private JTextField txtNewPass;
	private JTextField txtConPass;
	private JTextField txtNewEmail;
	private JTable tabFlightResults;
	private JTable table;
	private JTextField txtNumParti;
	private JTextField txtLowerPrice;
	private JTextField txtHigherPrice;
	private JTable tabDaytripResults;
	private JTable tabHotelResults;
	private JPasswordField pwdPassword;

	// Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmMetaSearchEngine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.

	public UserInterface() {
		initialize();
	}

	// Initialize the contents of the frame.

	private void initialize() {
		frmMetaSearchEngine = new JFrame();
		frmMetaSearchEngine.setTitle("Meta Search Engine");
		frmMetaSearchEngine.setBounds(100, 100, 1140, 610);
		frmMetaSearchEngine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMetaSearchEngine.getContentPane().setLayout(null);
		
		// Setting up main layout CardContainer
		final JPanel CardContainer = new JPanel();
		CardContainer.setBounds(0, 0, 1122, 563);
		frmMetaSearchEngine.getContentPane().add(CardContainer);
		final CardLayout mainLayout = new CardLayout();
		CardContainer.setLayout(mainLayout);
		
		// Setting up Login screen
		JPanel Login = new JPanel();
		CardContainer.add(Login, "Login");
		Login.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(431, 126, 95, 20);
		Login.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(530, 125, 180, 24);
		Login.add(txtUsername);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(435, 170, 95, 26);
		Login.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if legal name and password
				// if so, search through the database if
				// it matches any user
				// if so, open main screen with an instance
				// of the user class.
				mainLayout.show(CardContainer, "SplashScreen");
			}
		});
		btnSignIn.setBounds(431, 220, 125, 30);
		Login.add(btnSignIn);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSignUp = new JButton("New User");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLayout.show(CardContainer, "SignUp");
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUp.setBounds(585, 220, 125, 30);
		Login.add(btnSignUp);
		
		JLabel lblTitle = new JLabel("Welcome to Meta Search Engine");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblTitle.setBounds(331, 13, 460, 50);
		Login.add(lblTitle);
		
		JLabel lblSignIn = new JLabel("- Sign in and enjoy the benefits");
		lblSignIn.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		lblSignIn.setBounds(492, 63, 272, 23);
		Login.add(lblSignIn);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(530, 170, 180, 24);
		Login.add(pwdPassword);
		
		JPanel SignUp = new JPanel();
		CardContainer.add(SignUp, "SignUp");
		SignUp.setLayout(null);
		
		JLabel lblNewUsername = new JLabel("Username:");
		lblNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewUsername.setBounds(427, 141, 85, 20);
		SignUp.add(lblNewUsername);
		
		txtNewUsername = new JTextField();
		txtNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNewUsername.setBounds(512, 139, 160, 25);
		SignUp.add(txtNewUsername);
		txtNewUsername.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPassword.setBounds(432, 176, 80, 20);
		SignUp.add(lblNewPassword);
		
		txtNewPass = new JTextField();
		txtNewPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNewPass.setBounds(512, 174, 160, 25);
		SignUp.add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(380, 211, 120, 20);
		SignUp.add(lblConfirmPassword);
		
		txtConPass = new JTextField();
		txtConPass.setBounds(512, 209, 160, 25);
		SignUp.add(txtConPass);
		txtConPass.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(460, 245, 52, 20);
		SignUp.add(lblEmail);
		
		txtNewEmail = new JTextField();
		txtNewEmail.setBounds(512, 245, 160, 25);
		SignUp.add(txtNewEmail);
		txtNewEmail.setColumns(10);
		
		JLabel lblNewUser = new JLabel("Create New User");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewUser.setBounds(460, 98, 181, 30);
		SignUp.add(lblNewUser);
		
		JButton btnSignUp_1 = new JButton("Sign Up...");
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignUp_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp_1.setBounds(470, 283, 150, 30);
		SignUp.add(btnSignUp_1);
		
		JLabel lblorGoHome = new JLabel("...or go home");
		lblorGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainLayout.previous(CardContainer);
			}
		});
		lblorGoHome.setBounds(535, 318, 85, 25);
		SignUp.add(lblorGoHome);
		
		JLabel lblSignupHead = new JLabel("Be a member of the MSE family");
		lblSignupHead.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblSignupHead.setBounds(348, 13, 470, 50);
		SignUp.add(lblSignupHead);
		
		JLabel lblAndNever = new JLabel("... and never lose the cool!");
		lblAndNever.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		lblAndNever.setBounds(558, 62, 220, 23);
		SignUp.add(lblAndNever);
		
		//SplashScreen.add(btnBack);
		//frmMetaSearchEngine.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLogin, btnSignUp, btnFlightSearch, btnHotelSearch, btnDaytripSearch, lblUsername, lblPassword, btnSignIn}));
		
		// Setting up the initial screen as part of CardContainer which covers all the window
		JPanel SplashScreen = new JPanel();
		CardContainer.add(SplashScreen, "SplashScreen");
		SplashScreen.setLayout(null);
		
		// Setting up SearchCriteria cards
		final JPanel SearchCriteria = new JPanel();
		SearchCriteria.setBounds(25, 76, 390, 437);
		SplashScreen.add(SearchCriteria);
		final CardLayout searchLayout = new CardLayout();
		SearchCriteria.setLayout(searchLayout);
		
		// Setting up Flight search criteria
		JButton btnFlightSearch = new JButton("Flight Search");
		btnFlightSearch.setForeground(Color.BLACK);
		btnFlightSearch.setBounds(15, 13, 120, 40);
		SplashScreen.add(btnFlightSearch);
		btnFlightSearch.setBackground(UIManager.getColor("Button.background"));
		
		btnFlightSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchLayout.show(SearchCriteria,"FlightSearch");
			}
		});
		
		JPanel FlightSearch = new JPanel();
		SearchCriteria.add(FlightSearch, "FlightSearch");
		FlightSearch.setLayout(null);
		
		JLabel lblDepLocation = new JLabel("Dep. Location:");
		lblDepLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepLocation.setBounds(12, 55, 100, 16);
		FlightSearch.add(lblDepLocation);
		
		final JComboBox txtDepLoc = new JComboBox();
		txtDepLoc.setModel(new DefaultComboBoxModel(new String[] {"Akureyri", "Egilsstaðir", "Reykjavík"}));
		AutoCompletion.enable(txtDepLoc);
		txtDepLoc.setEditable(true);
		txtDepLoc.setBounds(112, 53, 240, 22);
		FlightSearch.add(txtDepLoc);
		
		JLabel lblFlightSearch = new JLabel("Flight Search");
		lblFlightSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlightSearch.setBounds(140, 13, 109, 22);
		FlightSearch.add(lblFlightSearch);
		
		JLabel lblArrLocation = new JLabel("Arr. Location:");
		lblArrLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArrLocation.setBounds(12, 90, 100, 16);
		FlightSearch.add(lblArrLocation);
		
		final JComboBox txtArrLoc = new JComboBox();
		txtArrLoc.setModel(new DefaultComboBoxModel(new String[] {"Akureyri", "Egilsstaðir", "Reykjavík"}));
		AutoCompletion.enable(txtArrLoc);
		txtArrLoc.setEditable(true);
		txtArrLoc.setBounds(112, 87, 240, 22);
		FlightSearch.add(txtArrLoc);
		
		JLabel lblDepTime = new JLabel("Dep. Time:");
		lblDepTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepTime.setBounds(12, 125, 100, 16);
		FlightSearch.add(lblDepTime);
		
		final JDateChooser depTime = new JDateChooser();
		depTime.setBounds(112, 119, 240, 22);
		FlightSearch.add(depTime);
		
		JLabel lblPriceRange = new JLabel("Price Range:");
		lblPriceRange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceRange.setBounds(12, 313, 100, 16);
		FlightSearch.add(lblPriceRange);
		
		txtLowerPriceBound = new JTextField();
		txtLowerPriceBound.setBounds(112, 310, 100, 22);
		FlightSearch.add(txtLowerPriceBound);
		txtLowerPriceBound.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(205, 313, 49, 16);
		FlightSearch.add(label);
		
		txtHigherPriceBound = new JTextField();
		txtHigherPriceBound.setBounds(251, 310, 101, 22);
		FlightSearch.add(txtHigherPriceBound);
		txtHigherPriceBound.setColumns(10);
		
		JLabel lblNrSeats = new JLabel("Nr. Seats:");
		lblNrSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNrSeats.setBounds(12, 160, 90, 16);
		FlightSearch.add(lblNrSeats);
		
		txtNrSeats = new JTextField();
		txtNrSeats.setText("1");
		txtNrSeats.setBounds(111, 157, 60, 22);
		FlightSearch.add(txtNrSeats);
		txtNrSeats.setColumns(10);
		
		JLabel lblReturnTrip = new JLabel("Return Trip:");
		lblReturnTrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnTrip.setBounds(12, 230, 83, 22);
		FlightSearch.add(lblReturnTrip);
		
		JRadioButton rdbtnRoundTripNo = new JRadioButton("No");
		btnGroupRndTrip.add(rdbtnRoundTripNo);
		rdbtnRoundTripNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnRoundTripNo.setBounds(177, 229, 61, 25);
		FlightSearch.add(rdbtnRoundTripNo);
		
		final JRadioButton rdbtnRoundTripYes = new JRadioButton("Yes");
		btnGroupRndTrip.add(rdbtnRoundTripYes);
		rdbtnRoundTripYes.setSelected(true);
		rdbtnRoundTripYes.setBounds(112, 229, 61, 25);
		FlightSearch.add(rdbtnRoundTripYes);
		
		JLabel lblSeatClass = new JLabel("Class:");
		lblSeatClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeatClass.setBounds(12, 195, 100, 16);
		FlightSearch.add(lblSeatClass);
		
		final JComboBox txtSeatClass = new JComboBox();
		txtSeatClass.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Business"}));
		txtSeatClass.setBounds(112, 192, 131, 22);
		FlightSearch.add(txtSeatClass);
		
		JLabel lblOptional = new JLabel("Optional");
		lblOptional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOptional.setBounds(161, 278, 83, 25);
		FlightSearch.add(lblOptional);
		
		JLabel lblOverlay = new JLabel("Overlay:");
		lblOverlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOverlay.setBounds(12, 348, 100, 16);
		FlightSearch.add(lblOverlay);
		
		final JRadioButton rdbtnOverlayYes = new JRadioButton("Yes");
		btnGroupOverlay.add(rdbtnOverlayYes);
		rdbtnOverlayYes.setSelected(true);
		rdbtnOverlayYes.setBounds(112, 344, 61, 25);
		FlightSearch.add(rdbtnOverlayYes);
		
		JRadioButton rdbtnOverlayNo = new JRadioButton("No");
		btnGroupOverlay.add(rdbtnOverlayNo);
		rdbtnOverlayNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOverlayNo.setBounds(177, 344, 61, 25);
		FlightSearch.add(rdbtnOverlayNo);
		
		JButton btnSearchFlight = new JButton("Search");
		btnSearchFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightSearchCriteria newFlightSearch = new FlightSearchCriteria();
				newFlightSearch.setDepartureLoc((String) txtDepLoc.getSelectedItem());
				newFlightSearch.setArrivalLoc((String) txtArrLoc.getSelectedItem());
				newFlightSearch.setDepartureTime(depTime.getDate());
				newFlightSearch.setNumSeats(Integer.parseInt(txtNrSeats.getText()));
				newFlightSearch.setSeatClass((String)txtSeatClass.getSelectedItem());
				newFlightSearch.setReturnTrip(rdbtnRoundTripYes.isSelected());
				newFlightSearch.setPriceRange(new int[]{Integer.parseInt(txtLowerPriceBound.getText()),Integer.parseInt(txtHigherPriceBound.getText())});
				newFlightSearch.setOverLay(rdbtnOverlayYes.isSelected());
				
				List<FlightAbstract> flightResults = SearchEngine.flightSearch(newFlightSearch);
				if (flightResults.size() == 0) {
					System.out.println("Unfortunately no flights were found");
				} else if (flightResults.size() > 0) {
					// Display list of results
				}
			}
		});
		btnSearchFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchFlight.setBounds(109, 386, 185, 38);
		FlightSearch.add(btnSearchFlight);
		
		// Setting up Hotel search criteria
		JButton btnHotelSearch = new JButton("Hotel Search");
		btnHotelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchLayout.show(SearchCriteria,"HotelSearch");
			}
		});
		btnHotelSearch.setBounds(155, 13, 120, 40);
		SplashScreen.add(btnHotelSearch);
		btnHotelSearch.setBackground(UIManager.getColor("Button.background"));
		
		JPanel HotelSearch = new JPanel();
		SearchCriteria.add(HotelSearch, "HotelSearch");
		HotelSearch.setLayout(null);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(12, 54, 100, 17);
		HotelSearch.add(lblLocation);
		
		JLabel lblHotelSearch = new JLabel("Hotel Search");
		lblHotelSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHotelSearch.setBounds(140, 13, 109, 22);
		HotelSearch.add(lblHotelSearch);
		
		JComboBox txtHotelLoc = new JComboBox();
		txtHotelLoc.setModel(new DefaultComboBoxModel(new String[] {"Reykjavík", "Akureyri"}));
		AutoCompletion.enable(txtHotelLoc);
		txtHotelLoc.setEditable(true);
		txtHotelLoc.setBounds(112, 53, 240, 22);
		HotelSearch.add(txtHotelLoc);
		
		JDateChooser dateCheckin = new JDateChooser();
		dateCheckin.setBounds(12, 120, 150, 22);
		HotelSearch.add(dateCheckin);
		
		JLabel lblCheckIn = new JLabel("Check in");
		lblCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckIn.setBounds(12, 95, 60, 16);
		HotelSearch.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("Check out");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckOut.setBounds(201, 95, 71, 16);
		HotelSearch.add(lblCheckOut);
		
		JDateChooser dateCheckOut = new JDateChooser();
		dateCheckOut.setBounds(201, 120, 150, 22);
		HotelSearch.add(dateCheckOut);
		
		JButton btnSearchHotel = new JButton("Search");
		btnSearchHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check if data is acceptable
				// if acceptable create HotelSearchCriteria
				// Search for hotels and call result display
			}
		});
		btnSearchHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchHotel.setBounds(109, 200, 185, 38);
		HotelSearch.add(btnSearchHotel);
		
		JPanel DaytripSearch = new JPanel();
		SearchCriteria.add(DaytripSearch, "name_282145842151674");
		DaytripSearch.setLayout(null);
		
		JLabel lblDayTripSearch = new JLabel("Day Trip Search");
		lblDayTripSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDayTripSearch.setBounds(125, 13, 135, 22);
		DaytripSearch.add(lblDayTripSearch);
		
		JLabel lblNrParti = new JLabel("Nr. of Trippers:");
		lblNrParti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNrParti.setBounds(12, 221, 100, 16);
		DaytripSearch.add(lblNrParti);
		
		txtNumParti = new JTextField();
		txtNumParti.setText("1");
		txtNumParti.setBounds(112, 218, 60, 22);
		DaytripSearch.add(txtNumParti);
		txtNumParti.setColumns(10);
		
		JLabel lblTimeFrame = new JLabel("Time frame:");
		lblTimeFrame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeFrame.setBounds(12, 179, 83, 16);
		DaytripSearch.add(lblTimeFrame);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setBounds(112, 159, 67, 16);
		DaytripSearch.add(lblStartTime);
		
		JDateChooser dateStartTime = new JDateChooser();
		dateStartTime.setBounds(112, 179, 76, 22);
		DaytripSearch.add(dateStartTime);
		
		JDateChooser dateEndTime = new JDateChooser();
		dateEndTime.setBounds(231, 179, 76, 22);
		DaytripSearch.add(dateEndTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setBounds(231, 159, 67, 16);
		DaytripSearch.add(lblEndTime);
		
		JLabel label_1 = new JLabel("-");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(206, 180, 26, 16);
		DaytripSearch.add(label_1);
		
		JLabel lblPriceRangeDay = new JLabel("Price Range:");
		lblPriceRangeDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceRangeDay.setBounds(12, 259, 100, 18);
		DaytripSearch.add(lblPriceRangeDay);
		
		txtLowerPrice = new JTextField();
		txtLowerPrice.setColumns(10);
		txtLowerPrice.setBounds(112, 256, 100, 22);
		DaytripSearch.add(txtLowerPrice);
		
		JLabel label_2 = new JLabel("-");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(205, 259, 49, 16);
		DaytripSearch.add(label_2);
		
		txtHigherPrice = new JTextField();
		txtHigherPrice.setColumns(10);
		txtHigherPrice.setBounds(251, 256, 101, 22);
		DaytripSearch.add(txtHigherPrice);
		
		JLabel lblLocation_1 = new JLabel("Location:");
		lblLocation_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation_1.setBounds(12, 126, 80, 16);
		DaytripSearch.add(lblLocation_1);
		
		JComboBox txtLocation = new JComboBox();
		txtLocation.setEditable(true);
		txtLocation.setModel(new DefaultComboBoxModel(new String[] {"Akureyri", "Egilsstaðir", "Reykjavík"}));
		txtLocation.setBounds(112, 124, 240, 22);
		DaytripSearch.add(txtLocation);
		
		JButton btnSearchDaytrip = new JButton("Search");
		btnSearchDaytrip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchDaytrip.setBounds(109, 291, 185, 38);
		DaytripSearch.add(btnSearchDaytrip);
		
		JLabel lblNameOfTrip = new JLabel("Name of trip:");
		lblNameOfTrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameOfTrip.setBounds(12, 55, 80, 16);
		DaytripSearch.add(lblNameOfTrip);
		
		JComboBox txtNameOfTrip = new JComboBox();
		txtNameOfTrip.setModel(new DefaultComboBoxModel(new String[] {"Golden circle", "Mount climbing on Arnarhóll", "Northen lights maniacs"}));
		txtNameOfTrip.setEditable(true);
		txtNameOfTrip.setBounds(112, 53, 240, 22);
		DaytripSearch.add(txtNameOfTrip);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategory.setBounds(12, 90, 80, 18);
		DaytripSearch.add(lblCategory);
		
		JComboBox txtCategory = new JComboBox();
		txtCategory.setModel(new DefaultComboBoxModel(new String[] {"Romantic", "Extreme", "Chill", "Insane"}));
		txtCategory.setEditable(true);
		txtCategory.setBounds(112, 88, 240, 22);
		DaytripSearch.add(txtCategory);
		
		// Setting up Daytrip search criteria
		JButton btnDaytripSearch = new JButton("Daytrip Search");
		btnDaytripSearch.setBounds(295, 13, 120, 40);
		SplashScreen.add(btnDaytripSearch);
		btnDaytripSearch.setBackground(UIManager.getColor("Button.background"));
		
		JPanel SearchResults = new JPanel();
		SearchResults.setBounds(443, 76, 667, 437);
		SplashScreen.add(SearchResults);
		SearchResults.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPaneFlight = new JScrollPane();
		SearchResults.add(scrollPaneFlight, "name_108767067643111");
		
		tabFlightResults = new JTable();
		tabFlightResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tabFlightResults.clearSelection();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tabFlightResults.rowAtPoint(e.getPoint());
				String Airline = (String) tabFlightResults.getModel().getValueAt(row,0);
				Date depTime = (Date) tabFlightResults.getModel().getValueAt(row,1);
				
			}
		});
		tabFlightResults.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = tabFlightResults.rowAtPoint(e.getPoint());
				if (row > -1) {
					tabFlightResults.clearSelection();
					tabFlightResults.setRowSelectionInterval(row,row);
				}
			}
		});
		
		tabFlightResults.setSurrendersFocusOnKeystroke(true);
		tabFlightResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabFlightResults.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Airline", "Dep. Time", "Dep. Location", "To", "Arr. Time", "Arr. Location", "Price"
			}
		));
		tabFlightResults.getColumnModel().getColumn(2).setPreferredWidth(90);
		tabFlightResults.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabFlightResults.getColumnModel().getColumn(5).setPreferredWidth(85);
		tabFlightResults.getColumnModel().getColumn(6).setPreferredWidth(65);
		scrollPaneFlight.setViewportView(tabFlightResults);
		
		JScrollPane scrollPaneDaytrip = new JScrollPane();
		SearchResults.add(scrollPaneDaytrip, "name_285815963765841");
		
		tabDaytripResults = new JTable();
		tabDaytripResults.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Organizer", "Type", "Location", "Go time", "Return time", "Price"
			}
		));
		scrollPaneDaytrip.setViewportView(tabDaytripResults);
		
		JScrollPane scrollPaneHotel = new JScrollPane();
		SearchResults.add(scrollPaneHotel, "name_285932842491231");
		
		tabHotelResults = new JTable();
		scrollPaneHotel.setViewportView(tabHotelResults);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// userLoggedIn = null;
				// displayLogin();
			}
		});
		btnNewButton.setBounds(1013, 13, 97, 25);
		SplashScreen.add(btnNewButton);
		
		JLabel lblUserLoggedIn = new JLabel("User logged in");
		lblUserLoggedIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserLoggedIn.setBounds(785, 13, 97, 22);
		SplashScreen.add(lblUserLoggedIn);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// displayEditProfile(User userToEdit)
			}
		});
		btnEditProfile.setBounds(906, 13, 97, 25);
		SplashScreen.add(btnEditProfile);
		
		JPanel Booking = new JPanel();
		CardContainer.add(Booking, "name_207987206227820");
		Booking.setLayout(null);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(1013, 13, 97, 25);
		Booking.add(btnLogOut);
		
		JLabel lblUserLoggedIn2 = new JLabel("User logged in");
		lblUserLoggedIn2.setBounds(785, 13, 97, 22);
		Booking.add(lblUserLoggedIn2);
		lblUserLoggedIn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditProfile_1 = new JButton("Edit Profile");
		btnEditProfile_1.setBounds(906, 13, 97, 25);
		Booking.add(btnEditProfile_1);
		
		JPanel BookingDisplay = new JPanel();
		BookingDisplay.setBounds(0, 60, 1110, 503);
		Booking.add(BookingDisplay);
		BookingDisplay.setLayout(new CardLayout(0, 0));
		
		JPanel FlightBooking = new JPanel();
		BookingDisplay.add(FlightBooking, "name_351337352329809");
		FlightBooking.setLayout(null);
		
		JLabel lblFlightBooking = new JLabel("Flight Booking");
		lblFlightBooking.setBounds(460, 13, 202, 34);
		lblFlightBooking.setFont(new Font("Tahoma", Font.BOLD, 28));
		FlightBooking.add(lblFlightBooking);
		
		JPanel FlightBookingCards = new JPanel();
		FlightBookingCards.setBounds(12, 67, 1098, 436);
		FlightBooking.add(FlightBookingCards);
		FlightBookingCards.setLayout(new CardLayout(0, 0));
		
		JPanel FlightBookingConfig = new JPanel();
		FlightBookingCards.add(FlightBookingConfig, "name_208877203966821");
		FlightBookingConfig.setLayout(null);
		
		JLabel lblSelectFromAvailable = new JLabel("Select from available seats:");
		lblSelectFromAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectFromAvailable.setBounds(50, 13, 200, 22);
		FlightBookingConfig.add(lblSelectFromAvailable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 12, 84, 88);
		FlightBookingConfig.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"11A", "11B", "12C", "14F", "11A", "11B", "12C", "14F"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblSeatsChosen = new JLabel("Seats chosen:");
		lblSeatsChosen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeatsChosen.setBounds(50, 134, 110, 22);
		FlightBookingConfig.add(lblSeatsChosen);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setCellSelectionEnabled(true);
		table.setBounds(50, 169, 300, 32);
		FlightBookingConfig.add(table);
		btnEditProfile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// displayEditUser(User userToEdit);
			}
		});
		
		JPanel EditUser = new JPanel();
		CardContainer.add(EditUser, "name_63891211660140");
		EditUser.setLayout(null);
		
		JLabel Heading = new JLabel("Define yourself");
		Heading.setBounds(10, 11, 1102, 59);
		Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		EditUser.add(Heading);
		
		final JTextField editUserUsername = new JTextField();
		editUserUsername.setBounds(537, 125, 200, 20);
		EditUser.add(editUserUsername);
		editUserUsername.setColumns(10);
		
		final JTextField editUserPassword = new JTextField();
		editUserPassword.setBounds(537, 175, 200, 20);
		EditUser.add(editUserPassword);
		editUserPassword.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername_1.setBounds(460, 124, 67, 19);
		EditUser.add(lblUsername_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword_1.setBounds(460, 174, 67, 19);
		EditUser.add(lblPassword_1);
		
		JLabel lblConfirmPassword_1 = new JLabel("Confirm password");
		lblConfirmPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword_1.setBounds(411, 227, 116, 19);
		EditUser.add(lblConfirmPassword_1);
		
		final JTextField editUserConfirmPassword = new JTextField();
		editUserConfirmPassword.setColumns(10);
		editUserConfirmPassword.setBounds(537, 228, 200, 20);
		EditUser.add(editUserConfirmPassword);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(502, 330, 25, 19);
		EditUser.add(lblAge);
		
		final JTextField editUserAge = new JTextField();
		editUserAge.setColumns(10);
		editUserAge.setBounds(537, 331, 200, 20);
		EditUser.add(editUserAge);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail_1.setBounds(494, 280, 33, 19);
		EditUser.add(lblEmail_1);
		
		final JTextField editUserEmail = new JTextField();
		editUserEmail.setColumns(10);
		editUserEmail.setBounds(537, 281, 200, 20);
		EditUser.add(editUserEmail);
		
		JButton editUserSaveChanges = new JButton("Save Changes");
		editUserSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here we are saving the changes!
			}
		});
		editUserSaveChanges.setBackground(Color.GREEN);
		editUserSaveChanges.setBounds(460, 406, 116, 23);
		EditUser.add(editUserSaveChanges);
		
		JButton editUserCancel = new JButton("Cancel");
		editUserCancel.setBackground(Color.RED);
		editUserCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Here we are cancelling
			}
		});
		editUserCancel.setBounds(621, 406, 116, 23);
		EditUser.add(editUserCancel);
	}
}*/
