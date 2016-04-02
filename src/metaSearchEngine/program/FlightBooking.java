package metaSearchEngine.program;

import java.util.ArrayList;
import java.util.Date;

import metaSearchEngine.mockobjects.Flight;

public class FlightBooking extends Booking {

	// Define attributes of the class
	private Flight flight;
	private String seatNr;
	private int luggage;
	private boolean flightMeal;
	private Date departureTime;
	private String departureLoc;
	private String arrivalLoc;
	private String flightNr;

	public static void testInput(Flight fightSearchResult) {
		Flight flight = fightSearchResult;
		if(flight==null) throw new IllegalArgumentException("Error: Search result class contains no value. ");
		
		String flightNumber = flight.get_flightNr();
		if(flightNumber==null) throw new IllegalArgumentException("Error: Flight number is missing.");
		else if (!flightNumber.matches("^([A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])[A-Z]?[0-9]{1,4}[A-Z]?$")) {
			throw new IllegalArgumentException("Error: Flight number has incorrect format.");
		}
		
		Date depTime = flight.get_depTime();
		if(depTime==null) throw new IllegalArgumentException("Error: Departure time is missing.");
		else if(depTime.length()!=19) throw new IllegalArgumentException("Error: Departure time of wrong length");
		// Note: It is still possible to set invalid departure time. 31st of febuary for example. Refine regexp
		else if(!depTime.matches("^2[01][0-9][0-9]-(0[1-9]|1[0-2])-([0-2][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) {
			throw new IllegalArgumentException("Error: Departure time on uncorrect format. ");
		}
	
		String depLoc = flight.get_depLoc();
		if(depLoc==null) {
			throw new IllegalArgumentException("Error: Departure location is missing.");
		}
		else if(depLoc.length()<3 || depLoc.length()>100) {
			throw new IllegalArgumentException("Error: Departure location of wrong length");
		}
		else if(!depLoc.matches("^[A-Z].*") && !depLoc.matches("^[a-z].*")) {
			throw new IllegalArgumentException("Error: Departure location does not start with a letter");
		}
	
		String arrivLoc = flight.get_arrivLoc();
		if(arrivLoc==null) {
			throw new IllegalArgumentException("Error: Arrival location is missing.");
		}
		else if(arrivLoc.length()<3 || arrivLoc.length()>100) {
			throw new IllegalArgumentException("Error: Arrival location of wrong length");
		}
		else if(!arrivLoc.matches("^[A-Z].*") && !arrivLoc.matches("^[a-z].*")) {
			throw new IllegalArgumentException("Error: Arrival location does not start with a letter");
		}
	
		int flightprice = flight.get_price();
		if(flightprice < 0 || flightprice > 100000000) throw new IllegalArgumentException("Error: Unrealistic price setting");
		
		ArrayList<String> dealer_info = flight.get_dealerInfo();
		String[] dealerFields = new String[]{"name", "location", "ID number", "Tax number"};
		if(dealer_info.size() < 4) {
			throw new IllegalArgumentException("Error: Dealer info is missing some info");
		} else if (dealer_info.size() > 4) {
			throw new IllegalArgumentException("Error: Dealer info array contains to much info ");
		} else {
			for (int i=0; i<dealer_info.size(); i++) {
				if (dealer_info.get(i).length()==0) {
					throw new IllegalArgumentException("Error: Dealer " + dealerFields[i] + " is missing");
				}
			}
			if (!dealer_info.get(1).matches("^[\\p{L}]{3,15} [0-9]{2,3} - [0-9]{3,3} [\\p{L}]{3,15}$")) {
				throw new IllegalArgumentException("Error: The dealers address has incorrect format ");
			} else if (!dealer_info.get(2).matches("^Kt. [0-9]{6,6}[-]?[0-9]{4,4}")) {
				throw new IllegalArgumentException("Error: The dealers ID number has incorrect format ");
			} else if (!dealer_info.get(3).matches("^Vsknr. [0-9]{6,6}")) {
				throw new IllegalArgumentException("Error: The dealers tax number has incorrect format ");
			}
		}
		
	}

	// Constructor:
	public FlightBooking(Flight fightSearchResult, String seat, String buyer){
		this.customer = buyer;		
		this.flight = fightSearchResult;	
		this.seatNr = seat;
		this.luggage = 0;
		this.flightMeal = false;
		this.departureTime = flight.get_depTime();
		this.departureLoc = flight.get_depLoc();
		this.arrivalLoc = flight.get_arrivLoc();
		this.price = flight.get_price();
		this.dealerInfo = flight.get_dealerInfo();
		this.flightNr = flight.get_flightNr();
	}

	// Notkun: seatNr = setSeat(seat)
	// Fyrir: seatNr is a string on the form [0-9][0-9][A-F]
	// Eftir: Gildi seatNr hefur veri� breytt �.a �a� inniheldur n� gildi seat. 
	public void setSeat(String seat)
	{
		if(seat.length() < 2 || seat.length() > 3) throw new IllegalArgumentException("Error: Incorrect format of seatNr");
		seatNr = seat;
	}

	// Notkun: luggage = setLuggage(luggage)
	// Fyrir: luggage er heiltala, m� vera n�ll. Engin efri m�rk.
	// Eftir: luggage breytar hefur veri� uppf�r� � samr�mi vi� inntak. 
	public void setLuggage(int nr_of_bags) {
		if(nr_of_bags < 0) throw new IllegalArgumentException("Please select a positive integer for the number of bags requested");
		else luggage = nr_of_bags;
	}

	// Notkun: flightMeal = setFlightMeal
	public void setFlightMeal(boolean flightfood) {
		flightMeal = flightfood;
	}

	// Usage: writeReview("some review text");
	// Before: 
	// After: The new review text has been added to the list of reviews
	void writeReview(String new_review) {
		review.add(new_review);
		// Still need to implement review submission. Not a high priority user story.
	}

	// Usage: getInfo()
	// 
	@Override
	public void getInfo() {
		// We want to call a function (?) to display a window containing the information
		// about the FlightBooking?? 
		// For now I will just print the information to the console.
		System.out.println("Welcome " + customer + "!");
		System.out.println("This is your booking information");
		System.out.println("Your have booked seat " + seatNr + "on flight " + flightNr);
		System.out.println("The price of this booking is " + String.valueOf(price) + " ISK");
		System.out.println("You will be departing for " + arrivalLoc + "from " + departureLoc + " at " + departureTime);
		System.out.println("You have selected to bring " + String.valueOf(luggage) + " bags");
		if(flightMeal==false) System.out.println("You have not ordered a meal in this flight");
		else System.out.println("You have ordered a meal in this flight");
		//System.out.println("Some more information....");
	}
}
