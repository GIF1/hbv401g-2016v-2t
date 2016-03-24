package metaSearchEngine.program;

import metaSearchEngine.mockobjects.Hotel;

public class HotelBooking extends Booking {


	// Declare class attributes: 
	private Hotel hotel;
	private int nrOfNights;
	private String roomType;
	private int nrOfMeals;


	public HotelBooking(Hotel hotelSearchResult){
		hotel = hotelSearchResult;
		nrOfNights=1;
		roomType="Single";
		nrOfMeals=0;
	}

	// Usage: roomType = setRoom(newRoom);
	// Before: roomType is a string, can be the empty string. Can only take value of roomType available. 
	// After: The value of roomType has been changed to newRoom
	public void setRoom(String newRoom) {
		if(newRoom=="Single" || newRoom=="Double" || newRoom=="Multi") this.roomType = newRoom;
		else throw new IllegalArgumentException("Error: Invalid roomtype. Please select Single, Double or Multi");
		
	}

	// Usage: nrOfMeals = changeMeal(meals_wanted);
	// Before: nrOfMeals is an integer specifying the nr of meals pr day the customer wants to eat at the hotel. 0 <= x < 5
	// After: nrOfMeals has been changed to meals_wanted
	public void changeMeal(int meals_wanted) {
		if(-1 < meals_wanted && meals_wanted < 5) nrOfMeals = meals_wanted;
		else throw new IllegalArgumentException("Error: The number of meals specified is not available. Please select a number between 0 and 4. ");
	}

	// Usage: nrOfNights = set_nrOfNights(nights_wanted);
	// Before: nrOfNights is an integer, specifying how many nights the customer intends to stay.
	// After: nrOfNights has been changed to nights_wanted
	public void set_nrOfNights(int nights_wanted) {
		if(nights_wanted < 0) throw new IllegalArgumentException("Error: You must book at least one whole night");
		nrOfNights = nights_wanted;
	}

	@Override
	public void getInfo() {
		System.out.println("Figure out a cool way to print the hotelInfo");
	}

	// The main method is here just for testing purposes. 
	public static void main(String[] args){

		HotelBooking prufubokun = new HotelBooking();
		prufubokun.customer = "Sigurgeir";
		prufubokun.price = 20000;
		prufubokun.nrOfNights = prufubokun.set_nrOfNights(4);
		System.out.println(prufubokun.nrOfNights);
		System.out.println(prufubokun.roomType);
		//prufubokun.roomType = prufubokun.setRoom("Multi");
		System.out.println(prufubokun.roomType);
		//prufubokun.nrOfMeals = prufubokun.changeMeal(8);
		
	}
}
