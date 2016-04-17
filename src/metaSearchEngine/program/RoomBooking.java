package metaSearchEngine.program;

public class RoomBooking extends Booking {

	private Room room;
	private Date fromDate;
	private Date toDate;

	// Constructor
	public RoomBooking(Room roomSearchResult, Date my_fromDate, DAte my_toDate){
		this.room = roomSearchResult;
		this.fromDate = my_fromDate;
		this.toDate = my_toDate;
	}


	// Usage: reservedDates = reserveRoom(my_reserveDate)
	// Before: The roomtype is available on my_reserveDate as otherwise
	// it would not have been part of the search results.
	// After: my_reserveDate has been added to the list of reserved dates in reserveDates
	package void reserveRoom(Date my_reserveDate) {
		reservedDates.add(my_reserveDate);
	}

	@Override
	public void getInfo() {
		System.out.println("Figure out a cool way to print the hotelInfo");
	}
}
