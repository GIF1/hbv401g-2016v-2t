package metaSearchEngine.mockobjects;

import java.util.*;

public class Flight {
	private final String flightNr;
	private String departureTime;
	private String departureLoc;
	private int price;
	private String arrivalLoc;
	private ArrayList<String> dealerInfo = new ArrayList<String>();

	public Flight(String flightNr, String departureTime, String departureLoc, String arrivalLoc, int price, ArrayList<String> dealerInfo) {
		this.flightNr = flightNr;
		this.departureTime = departureTime;
		this.departureLoc = departureLoc;
		this.arrivalLoc = arrivalLoc;
		this.price = price;
		this.dealerInfo = dealerInfo;
	}

	// Get methods for all the attributes
	public int get_price() {return price; }
	public String get_depTime() { return departureTime; }
	public String get_depLoc() { return departureLoc; }
	public String get_arrivLoc() { return arrivalLoc; }
	public ArrayList<String> get_dealerInfo() { return dealerInfo; }
	public String get_flightNr() {return flightNr; }
}
