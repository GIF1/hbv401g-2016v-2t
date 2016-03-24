package metaSearchEngine.mockobjects;

import java.util.*;

public class Flight {
	private final String flightNr;
	private String departureTime;
	private String departureLoc;
	private int price;
	private String arrivalLoc;
	private ArrayList<String> dealerInfo = new ArrayList<String>();

	public Flight(String flightnr, String depTime, String depLoc, String arrivLoc, int price_kr, ArrayList<String> sellerInfo) {
		this.flightNr = flightnr;
		this.departureTime = depTime;
		this.departureLoc = depLoc;
		this.arrivalLoc = arrivLoc;
		this.price = price_kr;
		this.dealerInfo = sellerInfo;
	}

	// Get methods for all the attributes
	public int get_price() {return price; }
	public String get_depTime() { return departureTime; }
	public String get_depLoc() { return departureLoc; }
	public String get_arrivLoc() { return arrivalLoc; }
	public ArrayList<String> get_dealerInfo() { return dealerInfo; }
	public String get_flightNr() {return flightNr; }
}
