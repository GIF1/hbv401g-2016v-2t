package metaSearchEngine.mockobjects;

import java.util.*;

public abstract class Flight {
	private String flightNr;
	private Date departureTime;
	private String departureLoc;
	private int price;
	private Date arrivalTime;
	private String arrivalLoc;
	private String[] seatNr;
	private String[] dealerInfo;

	public Flight(String flightNr, Date departureTime, String departureLoc, Date arrivalTime, 
			String arrivalLoc, int price, String[] dealerInfo, String[] seatNr) {
		this.flightNr = flightNr;
		this.departureTime = departureTime;
		this.departureLoc = departureLoc;
		this.arrivalTime = arrivalTime;
		this.arrivalLoc = arrivalLoc;
		this.price = price;
		this.dealerInfo = dealerInfo;
		this.seatNr = seatNr;
	}

	// Get methods for all the attributes
	//public void set_seatNr(String[] seatNr) {this.seatNr =seatNr; }
	public int get_price() {return price; }
	public Date get_depTime() { return departureTime; }
	public String get_depLoc() { return departureLoc; }
	public Date get_arrTime() { return arrivalTime; }
	public String get_arrivLoc() { return arrivalLoc; }
	public String[] get_dealerInfo() { return dealerInfo; }
	public String get_flightNr() {return flightNr; }
	public String[] get_seatNr() {return seatNr;}
}
