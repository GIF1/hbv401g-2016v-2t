package metaSearchEngine.mockobjects;

import java.util.*;

public class Hotel_mockobject {

	private int numRoomSingleAvail;

	public Hotel_mockobject(String flightnr, String depTime, String depLoc, String arrivLoc, int price_kr, ArrayList<String> sellerInfo) {
		flightNr = flightnr;
		departureTime = depTime;
		departureLoc = depLoc;
		arrivalLoc = arrivLoc;
		price = price_kr;
		dealerInfo = sellerInfo;
	}

	// Get methods for all the attributes
	public int get_price() {return price; }
	public String get_depTime() { return departureTime; }
	public String get_depLoc() { return departureLoc; }
	public String get_arrivLoc() { return arrivalLoc; }
	public ArrayList<String> get_dealerInfo() { return dealerInfo; }
	public String get_flightNr() {return flightNr; }
}
