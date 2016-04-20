package metaSearchEngine.program;

import java.util.Date;

@SuppressWarnings("serial")
public class HotelBooking extends Booking {
	//Attributes
	private HotelAbstract room;
	private Date CheckInDate;
	private Date CheckOutDate;

	// Constructor
	public HotelBooking(HotelAbstract roomSearchResult){
		this.room = roomSearchResult;
		this.CheckInDate = roomSearchResult.getStartTime();
		this.CheckOutDate = roomSearchResult.getEndTime();
		this.price = roomSearchResult.getPrice();
		this.dealerInfo = roomSearchResult.getDealerInfo();
		this.h = this;
	}

	//Setters
	public void setCheckInDate(Date CheckInDate) {this.CheckInDate = CheckInDate;}
	public void setCheckOutDate(Date CheckOutDate) {this.CheckOutDate = CheckOutDate;}
	
	//Getters
	public HotelAbstract getRoom() {return this.room;}
}
