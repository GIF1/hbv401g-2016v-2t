package metaSearchEngine.mockobjects;

import java.util.ArrayList;
import java.util.Date;

public class FlightExtend extends Flight{

	String flightNr;
	Date departureTime;
	String departureLoc;
	String arrivalLoc;
	int price;
	int numSeatsEconomy;
	int numSeatsComfort;
	String flightDuration;
	ArrayList<String> companyInfo;
	// .... possibly more
	
	public FlightExtend(String flightNr, Date departureTime, String departureLoc, String arrivalLoc, int price, 
			int numSeatsEconomy, int numSeatsComfort, String flightDuration, ArrayList<String> companyInfo) {
		super(flightNr, departureTime, departureLoc, arrivalLoc, price, companyInfo);
		
		this.flightNr = flightNr;
		this.departureTime = departureTime;
		this.departureLoc = departureLoc;
		this.arrivalLoc = arrivalLoc;
		this.price = price;
		this.numSeatsEconomy = numSeatsEconomy;
		this.numSeatsComfort = numSeatsComfort;
		this.flightDuration = flightDuration;
		this.companyInfo = companyInfo;
	}
}
