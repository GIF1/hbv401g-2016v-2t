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
	String departureLoc;
	String arrivalLoc;
	int[] priceRange;
	String seatClass;
	int numSeats;
	private boolean overLay;
	boolean returnTrip;
	
	// Methods
	public void setDepartureTime(Date depTime) {
		this.departureTime = depTime;
	}
	
	public void setDepartureLoc(String depLoc) {
		this.departureLoc = depLoc;
	}
	
	public void setArrivalLoc(String arrLoc) {
		this.arrivalLoc = arrLoc;
	}
	
	public void setPriceRange(int[] priceRange) {
		this.priceRange = priceRange;
	}
	
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	
	public void setOverLay() {
		
	}
	
	public void setReturnTrip(boolean returnTrip) {
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
