package metaSearchEngine.program;

import java.awt.EventQueue;


public class UserInterface {

	private JFrame frmMetaSearchEngine;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JComboBox<String> txtDepLoc;
	private JDateChooser depTime;
	private JComboBox<String> txtArrLoc;
	private JComboBox<String> txtSeatClass;
	private JRadioButton rdbtnRoundTripYes;
	private JTextField txtLowerPriceBound;
	private JTextField txtHigherPriceBound;
	private JTextField txtNrSeats;
	private final ButtonGroup btnGroupRndTrip = new ButtonGroup();
	private final ButtonGroup btnGroupOverlay = new ButtonGroup();
	private JComboBox<String> txtHotelLoc;
	private JTextField txtNewUsername;
	private JTextField txtNewPass;
	private JTextField txtConPass;
	private JTextField txtNewEmail;
	private JTable tabFlightResults;
	
	JPanel CardContainer = new JPanel();
	CardLayout mainLayout = new CardLayout();
	
	JPanel SearchCriteria = new JPanel();
	CardLayout searchLayout = new CardLayout();
	
	JPanel SearchResults = new JPanel();
	CardLayout resultLayout = new CardLayout();

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
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(435, 170, 95, 26);
		Login.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtPassword = new JTextField();
		txtPassword.setBounds(530, 170, 180, 24);
		Login.add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setText("Password");
		txtPassword.setToolTipText("");
		txtPassword.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if legal name and password
				// if so, search through the database if
				// it matches any user
				// if so, open main screen with an instance
				// of the user class.
				displayHomeScreen();
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
	
	private void displaySearchCriteria(JButton e) {
		
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
	}
	
	private void displayFlightSC() {
		JPanel FlightSearch = new JPanel();
		SearchCriteria.add(FlightSearch, "FlightSearch");
		FlightSearch.setLayout(null);
		searchLayout.show(SearchCriteria,"FlightSearch");
		
		JLabel lblDepLocation = new JLabel("Dep. Location:");
		lblDepLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepLocation.setBounds(12, 55, 100, 16);
		FlightSearch.add(lblDepLocation);
		
		JLabel lblFlightSearch = new JLabel("Flight Search");
		lblFlightSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlightSearch.setBounds(140, 13, 109, 22);
		FlightSearch.add(lblFlightSearch);
		
		txtDepLoc = new JComboBox<String>();
		txtDepLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"Akureyri", "Egilsstaðir", "Reykjavík"}));
		AutoCompletion.enable(txtDepLoc);
		txtDepLoc.setEditable(true);
		txtDepLoc.setBounds(112, 53, 240, 22);
		FlightSearch.add(txtDepLoc);
		
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
		
		JLabel lblDepTime = new JLabel("Dep. Time:");
		lblDepTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepTime.setBounds(12, 125, 100, 16);
		FlightSearch.add(lblDepTime);
		
		depTime = new JDateChooser();
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
		
		rdbtnRoundTripYes = new JRadioButton("Yes");
		btnGroupRndTrip.add(rdbtnRoundTripYes);
		rdbtnRoundTripYes.setSelected(true);
		rdbtnRoundTripYes.setBounds(112, 229, 61, 25);
		FlightSearch.add(rdbtnRoundTripYes);
		
		JLabel lblSeatClass = new JLabel("Class:");
		lblSeatClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeatClass.setBounds(12, 195, 100, 16);
		FlightSearch.add(lblSeatClass);
		
		txtSeatClass = new JComboBox<String>();
		txtSeatClass.setModel(new DefaultComboBoxModel<String>(new String[] {"Economy", "Business"}));
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
				newFlightSearch.setOverLay(rdbtnOverlayYes.isSelected());
				
				//List<Flight> flightResults = SearchEngine.flightSearch(newFlightSearch);
				
				List<Flight> flights = new ArrayList<Flight>();
				
				String[] wow_info = new String[]{"WOW air","555-5555","www.wow.is"};
				
				String[] ice_info = new String[]{"Icelandair","555-5556","www.icelandair.is"};
				
				//SimpleDateFormat duration = new SimpleDateFormat("HH:mm");
				//Date duration1 = duration.parse("02:15");
				
				@SuppressWarnings("deprecation")
				FlightExtend flight1 = new FlightExtend("AA123", new Date(2016,7-1,15,22,30), 
						"Akureyri", new Date(2016-1900,7+1,15,0,30), "Reykjavík", 12000,  
						new String[]{"13A", "13B", "11A"}, new String[]{"1A"}, wow_info);
				flights.add(flight1);
				
				@SuppressWarnings("deprecation")
				FlightExtend flight2 = new FlightExtend("AB456", new Date(2016,6-1,10,15,00), 
						"Egilsstaðir", new Date(2016-1900,6+1,10,18,00), "Vestmannaeyjar", 500000, 
						new String[]{"13A"}, new String[]{}, wow_info);
				flights.add(flight2);
				
				@SuppressWarnings("deprecation")
				FlightExtend flight3 = new FlightExtend("AC789", new Date(2016,7-1,22,12,30), 
						"Reykjavík", new Date(2016-1900,7+1,22,13,00), "Akureyri", 12000, 
						new String[]{}, new String[]{"1A", "2C", "2D"}, ice_info);
				flights.add(flight3);
				
				@SuppressWarnings("deprecation")
				FlightExtend flight4 = new FlightExtend("AC789", new Date(2016,7-1,15,12,30), 
						"Akureyri", new Date(2016-1900,7+1,15,14,30), "Reykjavík", 18000, 
						new String[]{"13A", "13B", "11A", "16D"}, new String[]{"1A", "2C", "2D"}, ice_info);
				flights.add(flight4);
				
				List<Flight> flightResults = flights;
				
				if (flightResults.size() == 0) {
					System.out.println("Unfortunately no flights were found");
				} else if (flightResults.size() > 0) {
					// Display list of results
					displayFlightResults(flightResults);
				}
				/*
				System.out.println("Bla");
				for (int i = 0; i<flightResults.size(); i++) {
					Flight flight = flightResults.get(i);
					System.out.println("Flight nr.\tDep. Location\tArr. Location\tDep. Time\t\t\tPrice\tDealer");
					System.out.println(flight.get_flightNr() + "\t\t" + flight.get_depLoc() + "\t" + flight.get_arrivLoc()
					 + "\t" + flight.get_depTime() + "\t" + flight.get_price() + "\t" + flight.get_dealerInfo().get(0));
				}*/
			}
		});
		btnSearchFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchFlight.setBounds(109, 386, 185, 38);
		FlightSearch.add(btnSearchFlight);
	}
	
	private void displayFlightResults(final List<Flight> flightResults) {
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
				User userLoggedIn = new User("Gunnar","gif1@hi.is","blabla",false,1);
				FlightBooking flightToBook = new FlightBooking(flightResults.get(row),1,userLoggedIn);
				displayFlightBooking(flightToBook);
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
			Flight flight = flightResults.get(i);
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
	
	private void displayFlightBooking(FlightBooking flightToBook) {
		
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
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(12, 54, 100, 17);
		DaytripSearch.add(lblLocation);
		
		JLabel lblHotelSearch = new JLabel("Daytrip Search");
		lblHotelSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHotelSearch.setBounds(140, 13, 109, 22);
		DaytripSearch.add(lblHotelSearch);
		
		JComboBox txtHotelLoc = new JComboBox();
		txtHotelLoc.setModel(new DefaultComboBoxModel(new String[] {"Reykjavík", "Akureyri"}));
		AutoCompletion.enable(txtHotelLoc);
		txtHotelLoc.setEditable(true);
		txtHotelLoc.setBounds(112, 53, 240, 22);
		DaytripSearch.add(txtHotelLoc);
		
		JDateChooser dateCheckin = new JDateChooser();
		dateCheckin.setBounds(12, 120, 150, 22);
		DaytripSearch.add(dateCheckin);
		
		JLabel lblCheckIn = new JLabel("Check in");
		lblCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckIn.setBounds(12, 95, 60, 16);
		DaytripSearch.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("Check out");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckOut.setBounds(201, 95, 71, 16);
		DaytripSearch.add(lblCheckOut);
		
		JDateChooser dateCheckOut = new JDateChooser();
		dateCheckOut.setBounds(201, 120, 150, 22);
		DaytripSearch.add(dateCheckOut);
		
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
		DaytripSearch.add(btnSearchHotel);
	}
}

/*
public class UserInterface {

	private JFrame frmMetaSearchEngine;
	private JTextField txtUsername;
	private JTextField txtPassword;
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
		
		txtPassword = new JTextField();
		txtPassword.setBounds(530, 170, 180, 24);
		Login.add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setText("Password");
		txtPassword.setToolTipText("");
		txtPassword.setColumns(10);
		
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
		
		// Setting up the Login buttons and listeners
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(542, 13, 97, 25);
		SplashScreen.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLayout.show(CardContainer, "Login");
			}
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		
		JButton btnSignUp1 = new JButton("Sign Up");
		btnSignUp1.setBounds(651, 13, 97, 25);
		SplashScreen.add(btnSignUp1);
		btnSignUp1.setBackground(UIManager.getColor("Button.light"));
		
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
				
				List<Flight> flightResults = SearchEngine.flightSearch(newFlightSearch);
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
	}
}*/
