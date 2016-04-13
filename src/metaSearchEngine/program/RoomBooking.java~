package metaSearchEngine.program;

public class RoomBooking extends Booking {

	private Room room;
	private String hotel;
	private List<Date> reservedDates;
	private int nrOfMeals=0;

	// Constructor
	public RoomBooking(Room roomSearchResult, List<Date> my_reserveDates, String hotel_with_room;){
		this.room = roomSearchResult;
		this.hotel = hotel_with_room;
		this.reservedDates = my_reserveDates;
	}
	// Usage: nrOfMeals = changeMeal(meals_wanted);
	// Before: nrOfMeals is an integer specifying the nr of meals pr day the customer wants to eat at the hotel. 0 <= x < 5
	// After: nrOfMeals has been changed to meals_wanted
	package void changeMeal(int meals_wanted) {
		if(-1 < meals_wanted && meals_wanted < 5) this.nrOfMeals = meals_wanted;
		else throw new IllegalArgumentException("Error: The number of meals specified is not available. Please select a number between 0 and 4. ");
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
