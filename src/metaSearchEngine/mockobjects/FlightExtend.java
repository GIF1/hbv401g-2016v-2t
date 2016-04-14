package metaSearchEngine.mockobjects;

import java.util.ArrayList;
import java.util.Date;

public class FlightExtend extends Flight{

	String flightNr;
	Date departureTime;
	String departureLoc;
	Date arrivalTime;
	String arrivalLoc;
	int price;
	//int numSeatsEconomy;
	//int numSeatsComfort;
	String[] seatNrEconomy;
	String[] seatNrComfort;
	//String flightDuration;
	String[] companyInfo;
	// .... possibly more
	
	public FlightExtend(String flightNr, Date departureTime, String departureLoc, Date arrivalTime, String arrivalLoc, int price, 
			String[] seatNrEconomy, String[] seatNrComfort, String[] companyInfo) {
		super(flightNr, departureTime, departureLoc, arrivalTime, arrivalLoc, price, companyInfo, seatNrEconomy);
		
		this.flightNr = flightNr;
		this.departureTime = departureTime;
		this.departureLoc = departureLoc;
		this.arrivalTime = arrivalTime;
		this.arrivalLoc = arrivalLoc;
		this.price = price;
		this.seatNrEconomy = seatNrEconomy;
		this.seatNrComfort = seatNrComfort;
		//this.flightDuration = flightDuration;
		this.companyInfo = companyInfo;
	}
}
