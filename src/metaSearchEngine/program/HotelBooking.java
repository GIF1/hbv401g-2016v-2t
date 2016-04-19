package metaSearchEngine.program;

import java.util.Date;

public class HotelBooking extends Booking {

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


	// Usage: reservedDates = reserveRoom(my_reserveDate)
	// Before: The roomtype is available on my_reserveDate as otherwise
	// it would not have been part of the search results.
	// After: my_reserveDate has been added to the list of reserved dates in reserveDates
	/*
	package void reserveRoom(Date my_reserveDate) {
		reservedDates.add(my_reserveDate);
	}*/
	public void setCheckInDate(Date CheckInDate) {this.CheckInDate = CheckInDate;}
	public void setCheckOutDate(Date CheckOutDate) {this.CheckOutDate = CheckOutDate;}
	
	public HotelAbstract getRoom() {return this.room;}

	/*
	@Override
	public void getInfo() {
		System.out.println("Figure out a cool way to print the hotelInfo");
	}*/
}
