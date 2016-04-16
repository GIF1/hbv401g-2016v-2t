/**
 * 
 */
package metaSearchEngine.program;

import java.util.Date;

public class FlightSearchCriteria {
	
	// Attributes
	private Date departureTime;
	private String departureLoc;
	private String arrivalLoc;
	private int[] priceRange;
	private String seatClass;
	private int numSeats;
	private boolean overLay;
	private boolean returnTrip;
	
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
	
	public void setOverLay(boolean overLay) {
		this.overLay = overLay;
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
