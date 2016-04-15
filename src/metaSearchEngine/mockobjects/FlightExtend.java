package metaSearchEngine.mockobjects;

import metaSearchEngine.program.FlightAbstract;
import java.util.Date;

public class FlightExtend extends FlightAbstract{

	String flightNr;
	Date departureTime;
	String departureLoc;
	Date arrivalTime;
	String arrivalLoc;
	int price;
	String[] seatNrEconomy;
	String[] seatNrComfort;
	String[] companyInfo;
	// .... possibly more
	
	public FlightExtend(String flightNr, Date departureTime, String departureLoc, Date arrivalTime, String arrivalLoc, int price, 
			String[] seatNrEconomy, String[] seatNrComfort, String[] companyInfo /*, ...*/) {
		super(flightNr, departureTime, departureLoc, arrivalTime, arrivalLoc, price, companyInfo);
		
		this.flightNr = flightNr;
		this.departureTime = departureTime;
		this.departureLoc = departureLoc;
		this.arrivalTime = arrivalTime;
		this.arrivalLoc = arrivalLoc;
		this.price = price;
		this.seatNrEconomy = seatNrEconomy;
		this.seatNrComfort = seatNrComfort;
		this.companyInfo = companyInfo;
		// ...
	}
}
