/**
 * 
 */
package metaSearchEngine.program;

import java.util.Date;

/**
 * @author Gunnar Atli
 *
 */
public class FlightSearchCriteria {
	
	// Attributes
	Date departureTime;
	//private String arrivalTime;
	String departureLoc;
	String arrivalLoc;
	private int[] priceRange;
	private String seatClass;
	private int numSeats;
	//private int numOfSeatsComfort;
	//private boolean overLay;
	private boolean returnTrip;
	
	// Methods
	void setDepartureTime(Date depTime) {
		this.departureTime = depTime;
	}
	
	void setArrivalTime() {
		
	}
	
	void setDepartureLoc(String depLoc) {
		this.departureLoc = depLoc;
	}
	
	void setArrivalLoc(String arrLoc) {
		this.arrivalLoc = arrLoc;
	}
	
	void setPriceRange(int[] priceRange) {
		this.priceRange = priceRange;
	}
	
	void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
	void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	
	void setOverLay() {
		
	}
	
	void setReturnTrip(boolean returnTrip) {
		this.returnTrip = returnTrip;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public String getDepartureLoc() {
		return departureLoc;
	}

	public String getArrivalLoc() {
		return arrivalLoc;
	}

	public int[] getPriceRange() {
		return priceRange;
	}

	public boolean getReturnTrip() {
		return returnTrip;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public String getSeatClass() {
		return seatClass;
	}
	
}
