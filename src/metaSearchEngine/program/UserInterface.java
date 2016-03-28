package metaSearchEngine.program;

import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.Component;
//import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.util.*;

@SuppressWarnings("serial")
public class UserInterface extends JFrame implements ActionListener{
	//private Flight flightSearchResults;
	//private Hotel hotelSearchResults;
	//private DayTrip dayTripSearchResults;
/*
	void displaySplashScreen() {
		
	}
	*/
	
	private JButton flightButton = new JButton("Flight search");
	private JButton hotelButton = new JButton("Hotel search");
	private JButton daytripButton = new JButton("Daytrip search");
	private JButton searchButton = new JButton("Search");
	
	void displaySplashScreen() {
		final JFrame frame = new JFrame("Search Engine");
		frame.setSize(500, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.setLayout(null);
		
		flightButton.setBounds(10, 10, 150, 25);
		hotelButton.setBounds(170, 10, 150, 25);
		daytripButton.setBounds(330, 10, 150, 25);
		
		panel.add(flightButton);
		panel.add(hotelButton);
		panel.add(daytripButton);
		
		ActionListener searchDisplay = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Object source = e.getSource();
				
				if (source == flightButton) {
					final FlightSearchCriteria newFlightSearch = new FlightSearchCriteria();
					
					panel.removeAll();
					frame.setSize(500, 450);
					
					flightButton.setBounds(10, 10, 150, 25);
					hotelButton.setBounds(170, 10, 150, 25);
					daytripButton.setBounds(330, 10, 150, 25);
					
					panel.add(flightButton);
					panel.add(hotelButton);
					panel.add(daytripButton);
					
					JLabel flightSearchLabel = new JLabel("Flight search");
					flightSearchLabel.setBounds(140, 40, 80, 25);
					panel.add(flightSearchLabel);
					
					JLabel depLocLabel = new JLabel("From:");
					depLocLabel.setBounds(10, 80, 80, 25);
					panel.add(depLocLabel);

					final JTextField depLocText = new JTextField(20);
					depLocText.setBounds(90, 80, 170, 25);
					panel.add(depLocText);
					
					JLabel arrivalLabel = new JLabel("To:");
					arrivalLabel.setBounds(10, 110, 80, 25);
					panel.add(arrivalLabel);

					final JTextField arrivalText = new JTextField(20);
					arrivalText.setBounds(90, 110, 170, 25);
					panel.add(arrivalText);
					
					JLabel depTimeLabel = new JLabel("Dep. Time:");
					depTimeLabel.setBounds(10, 140, 80, 25);
					panel.add(depTimeLabel);

					final JTextField depTimeText = new JTextField(20);
					depTimeText.setBounds(90, 140, 170, 25);
					panel.add(depTimeText);
					
					JLabel numPassengerLabel = new JLabel("Passengers:");
					numPassengerLabel.setBounds(10, 170, 80, 25);
					panel.add(numPassengerLabel);
					
					String[] passengerString = {"1","2","3","4"};
					JComboBox numPassenger = new JComboBox(passengerString);
					numPassenger.setBounds(90, 170, 170, 25);
					panel.add(numPassenger);
					
					searchButton.setBounds(90, 200, 100, 25);
					panel.add(searchButton);
					searchButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(depLocText.getText());
							newFlightSearch.setDepartureLoc(depLocText.getText());
							newFlightSearch.setArrivalLoc(arrivalText.getText());
							newFlightSearch.setDepartureTime(depTimeText.getText());
							
							List<List<String>> flightResults = SearchEngine.flightSearch(newFlightSearch);
							displayResults(flightResults,source);
						};
					});
					
					panel.updateUI();
				} else if (source == hotelButton) {
					panel.removeAll();
					frame.setSize(500, 450);
					
					flightButton.setBounds(10, 10, 150, 25);
					hotelButton.setBounds(170, 10, 150, 25);
					daytripButton.setBounds(330, 10, 150, 25);
					
					panel.add(flightButton);
					panel.add(hotelButton);
					panel.add(daytripButton);
					
					JLabel hotelSearchLabel = new JLabel("Hotel search");
					hotelSearchLabel.setBounds(140, 40, 80, 25);
					panel.add(hotelSearchLabel);
					
					JLabel depLocLabel = new JLabel("From:");
					depLocLabel.setBounds(10, 80, 70, 25);
					panel.add(depLocLabel);

					final JTextField depLocText = new JTextField(20);
					depLocText.setBounds(90, 80, 160, 25);
					panel.add(depLocText);
					
					JLabel arrivalLabel = new JLabel("To:");
					arrivalLabel.setBounds(10, 110, 70, 25);
					panel.add(arrivalLabel);

					final JTextField arrivalText = new JTextField(20);
					arrivalText.setBounds(90, 110, 160, 25);
					panel.add(arrivalText);
					
					JLabel depTimeLabel = new JLabel("Dep. Time:");
					depTimeLabel.setBounds(10, 140, 70, 25);
					panel.add(depTimeLabel);

					final JTextField depTimeText = new JTextField(20);
					depTimeText.setBounds(90, 140, 160, 25);
					panel.add(depTimeText);
					
					panel.updateUI();
				} else if (source == daytripButton) {
					panel.removeAll();
					frame.setSize(500, 450);
					
					flightButton.setBounds(10, 10, 150, 25);
					hotelButton.setBounds(170, 10, 150, 25);
					daytripButton.setBounds(330, 10, 150, 25);
					
					panel.add(flightButton);
					panel.add(hotelButton);
					panel.add(daytripButton);
					
					JLabel daytripSearchLabel = new JLabel("Daytrip search");
					daytripSearchLabel.setBounds(140, 40, 100, 25);
					panel.add(daytripSearchLabel);
					
					JLabel depLocLabel = new JLabel("From:");
					depLocLabel.setBounds(10, 80, 70, 25);
					panel.add(depLocLabel);

					final JTextField depLocText = new JTextField(20);
					depLocText.setBounds(90, 80, 160, 25);
					panel.add(depLocText);
					
					JLabel arrivalLabel = new JLabel("To:");
					arrivalLabel.setBounds(10, 110, 70, 25);
					panel.add(arrivalLabel);

					final JTextField arrivalText = new JTextField(20);
					arrivalText.setBounds(90, 110, 160, 25);
					panel.add(arrivalText);
					
					JLabel depTimeLabel = new JLabel("Dep. Time:");
					depTimeLabel.setBounds(10, 140, 70, 25);
					panel.add(depTimeLabel);

					final JTextField depTimeText = new JTextField(20);
					depTimeText.setBounds(90, 140, 160, 25);
					panel.add(depTimeText);
					
					panel.updateUI();
				}
			}
		};
		flightButton.addActionListener(searchDisplay);
		hotelButton.addActionListener(searchDisplay);
		daytripButton.addActionListener(searchDisplay);
		
		frame.setVisible(true);
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
	
	void displayResults(List<List <String>> results, Object source) {
		String[] colNames;

		if(source == flightButton) {
			colNames = new String[]{"Flight Nr.", "Dep. Location", "Arr. Location", "Dep. Time", "Price", "Company"};
		} else {
			colNames = new String[]{"Flight Nr.", "Dep. Location", "Arr. Location", "Dep. Time", "Price", "Company"};
		}
		
		DefaultTableModel model = createModel(results, colNames);
		model.addColumn("Booking");
		
		JTable table = new JTable(model);
		table.getColumn("Booking").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Booking").setCellEditor(
	        new ButtonEditor(new JCheckBox()));
		
		JFrame frame = new JFrame();
		frame.setSize(500, 250);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	void displayBooking(String[] bookingInfo) {
		for(int i=0; i<bookingInfo.length; i++) {
			System.out.println(bookingInfo[i]);
		}
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
	
	// This method is used to create model from List<List<String>> to use with JTable
	public DefaultTableModel createModel(List<List<String>> list, String[] columnNames) {

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (List<String> row : list) {
            model.addRow(row.toArray());
        }

        return model;
    }
	
	// This class is used to set booking buttons on a column next to
	// a line in the result table from searching.
	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			setText("Book");
			return this;
		}
	}

	/**
	 * @version 1.0 11/09/98
	 */

	// This class is used to set booking buttons on a column next to
	// a line in the result table from searching.
	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;

		private String label;
		private int myRow;
		private int myCol;
		private JTable table;

		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column) {
			this.table = table;
			this.myRow = row;
			this.myCol = column;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText("Book");
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
				// 
				// 
				//JOptionPane.showMessageDialog(button, myRow + ": Ouch!");
				// System.out.println(label + ": Ouch!");
				displayBooking(getRowAt(myRow));
			}
			isPushed = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
		
		public String[] getRowAt(int row) {
		     String[] result = new String[myCol];

		     for (int i = 0; i < myCol; i++) {
		         result[i] = (String) table.getModel().getValueAt(row, i);
		     }

		     return result;
		}
	}
	
	public static void main (String[] args) {
		//User user = new User();
		//user.login();
		UserInterface gui = new UserInterface();
		gui.displaySplashScreen();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
