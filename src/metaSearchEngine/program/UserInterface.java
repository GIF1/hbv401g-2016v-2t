package metaSearchEngine.program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;

import metaSearchEngine.mockobjects.Flight;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserInterface {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtDepLoc;
	private JTextField txtArrLoc;
	private JTextField txtLowerPriceBound;
	private JTextField txtHigherPriceBound;
	private JTextField txtNrSeats;
	private final ButtonGroup btnGroupRndTrip = new ButtonGroup();
	private final ButtonGroup btnGroupOverlay = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 778, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Setting up main layout CardContainer
		final JPanel CardContainer = new JPanel();
		CardContainer.setBounds(0, 0, 760, 628);
		frame.getContentPane().add(CardContainer);
		final CardLayout mainLayout = new CardLayout();
		CardContainer.setLayout(mainLayout);
		
		// Setting up the initial screen as part of CardContainer which covers all the window
		JPanel SplashScreen = new JPanel();
		CardContainer.add(SplashScreen, "name_28698229245372");
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
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(651, 13, 97, 25);
		SplashScreen.add(btnSignUp);
		btnSignUp.setBackground(UIManager.getColor("Button.light"));
		
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
		lblDepLocation.setBounds(12, 54, 100, 16);
		FlightSearch.add(lblDepLocation);
		
		JLabel lblFlightSearch = new JLabel("Flight Search");
		lblFlightSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlightSearch.setBounds(140, 13, 109, 22);
		FlightSearch.add(lblFlightSearch);
		
		txtDepLoc = new JTextField();
		txtDepLoc.setBackground(UIManager.getColor("TextField.background"));
		txtDepLoc.setBounds(112, 52, 240, 22);
		FlightSearch.add(txtDepLoc);
		txtDepLoc.setColumns(10);
		
		JLabel lblArrLocation = new JLabel("Arr. Location:");
		lblArrLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArrLocation.setBounds(12, 91, 100, 16);
		FlightSearch.add(lblArrLocation);
		
		txtArrLoc = new JTextField();
		txtArrLoc.setBackground(UIManager.getColor("TextField.background"));
		txtArrLoc.setBounds(112, 87, 240, 22);
		FlightSearch.add(txtArrLoc);
		txtArrLoc.setColumns(10);
		
		JLabel lblDepTime = new JLabel("Dep. Time:");
		lblDepTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepTime.setBounds(12, 125, 100, 16);
		FlightSearch.add(lblDepTime);
		
		final JDateChooser depTime = new JDateChooser();
		depTime.setBounds(112, 119, 240, 22);
		FlightSearch.add(depTime);
		
		JLabel lblPriceRange = new JLabel("Price Range:");
		lblPriceRange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceRange.setBounds(12, 307, 100, 22);
		FlightSearch.add(lblPriceRange);
		
		txtLowerPriceBound = new JTextField();
		txtLowerPriceBound.setBounds(112, 308, 100, 22);
		FlightSearch.add(txtLowerPriceBound);
		txtLowerPriceBound.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(205, 311, 49, 16);
		FlightSearch.add(label);
		
		txtHigherPriceBound = new JTextField();
		txtHigherPriceBound.setBounds(251, 308, 101, 22);
		FlightSearch.add(txtHigherPriceBound);
		txtHigherPriceBound.setColumns(10);
		
		JLabel lblNrSeats = new JLabel("Nr. Seats:");
		lblNrSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNrSeats.setBounds(12, 154, 90, 22);
		FlightSearch.add(lblNrSeats);
		
		txtNrSeats = new JTextField();
		txtNrSeats.setText("1");
		txtNrSeats.setBounds(111, 155, 60, 22);
		FlightSearch.add(txtNrSeats);
		txtNrSeats.setColumns(10);
		
		JLabel lblReturnTrip = new JLabel("Return Trip:");
		lblReturnTrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnTrip.setBounds(12, 227, 83, 22);
		FlightSearch.add(lblReturnTrip);
		
		JRadioButton rdbtnRoundTripNo = new JRadioButton("No");
		btnGroupRndTrip.add(rdbtnRoundTripNo);
		rdbtnRoundTripNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnRoundTripNo.setBounds(177, 226, 61, 25);
		FlightSearch.add(rdbtnRoundTripNo);
		
		final JRadioButton rdbtnRoundTripYes = new JRadioButton("Yes");
		btnGroupRndTrip.add(rdbtnRoundTripYes);
		rdbtnRoundTripYes.setSelected(true);
		rdbtnRoundTripYes.setBounds(112, 227, 61, 25);
		FlightSearch.add(rdbtnRoundTripYes);
		
		JLabel lblSeatClass = new JLabel("Class:");
		lblSeatClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeatClass.setBounds(12, 189, 100, 22);
		FlightSearch.add(lblSeatClass);
		
		final JComboBox txtSeatClass = new JComboBox();
		txtSeatClass.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Business"}));
		txtSeatClass.setBounds(112, 190, 131, 22);
		FlightSearch.add(txtSeatClass);
		
		JLabel lblOptional = new JLabel("Optional");
		lblOptional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOptional.setBounds(161, 278, 83, 25);
		FlightSearch.add(lblOptional);
		
		JLabel lblOverlay = new JLabel("Overlay:");
		lblOverlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOverlay.setBounds(12, 351, 100, 22);
		FlightSearch.add(lblOverlay);
		
		final JRadioButton rdbtnOverlayYes = new JRadioButton("Yes");
		btnGroupOverlay.add(rdbtnOverlayYes);
		rdbtnOverlayYes.setSelected(true);
		rdbtnOverlayYes.setBounds(112, 351, 61, 25);
		FlightSearch.add(rdbtnOverlayYes);
		
		JRadioButton rdbtnOverlayNo = new JRadioButton("No");
		btnGroupOverlay.add(rdbtnOverlayNo);
		rdbtnOverlayNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOverlayNo.setBounds(177, 350, 61, 25);
		FlightSearch.add(rdbtnOverlayNo);
		
		JButton btnSearchFlight = new JButton("Search");
		btnSearchFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightSearchCriteria newFlightSearch = new FlightSearchCriteria();
				newFlightSearch.setDepartureLoc(txtDepLoc.getText());
				newFlightSearch.setArrivalLoc(txtArrLoc.getText());
				newFlightSearch.setDepartureTime(depTime.getDate());
				newFlightSearch.setNumSeats(Integer.parseInt(txtNrSeats.getText()));
				newFlightSearch.setSeatClass((String)txtSeatClass.getSelectedItem());
				newFlightSearch.setReturnTrip(rdbtnRoundTripYes.isSelected());
				newFlightSearch.setPriceRange(new int[]{Integer.parseInt(txtLowerPriceBound.getText()),Integer.parseInt(txtHigherPriceBound.getText())});
				newFlightSearch.setOverLay(rdbtnOverlayYes.isSelected());
				
				List<Flight> flightResults = SearchEngine.flightSearch(newFlightSearch);
				System.out.println("Bla");
				for (int i = 0; i<flightResults.size(); i++) {
					Flight flight = flightResults.get(i);
					System.out.println("Flight nr.\tDep. Location\tArr. Location\tDep. Time\t\t\tPrice\tDealer");
					System.out.println(flight.get_flightNr() + "\t\t" + flight.get_depLoc() + "\t" + flight.get_arrivLoc()
					 + "\t" + flight.get_depTime() + "\t" + flight.get_price() + "\t" + flight.get_dealerInfo().get(0));
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
		
		// Setting up Daytrip search criteria
		JButton btnDaytripSearch = new JButton("Daytrip Search");
		btnDaytripSearch.setBounds(295, 13, 120, 40);
		SplashScreen.add(btnDaytripSearch);
		btnDaytripSearch.setBackground(UIManager.getColor("Button.background"));
		
		// Setting up Login screen
		JPanel Login = new JPanel();
		CardContainer.add(Login, "Login");
		Login.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(283, 127, 77, 20);
		Login.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(365, 126, 126, 23);
		Login.add(txtUsername);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(283, 172, 95, 26);
		Login.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtPassword = new JTextField();
		txtPassword.setBounds(365, 173, 126, 22);
		Login.add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setText("Password");
		txtPassword.setToolTipText("");
		txtPassword.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(337, 210, 97, 25);
		Login.add(btnSignIn);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLayout.previous(CardContainer);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(12, 590, 97, 25);
		Login.add(btnBack);
		
		//SplashScreen.add(btnBack);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLogin, btnSignUp, btnFlightSearch, btnHotelSearch, btnDaytripSearch, lblUsername, lblPassword, btnSignIn}));
	}
}
