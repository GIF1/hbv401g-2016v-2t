package metaSearchEngine.program;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Package implements Serializable {

	protected List <Booking> Trip = new ArrayList<Booking>();
	protected String packageName;
	
	// Constructor
	// A new package is made with new booking.
	public Package(Booking new_booking, String packageName) {
		this.Trip.add(new_booking);
		this.packageName = packageName;
	}

	// Usage: addToTrip(new_booking)
	// Before: Trip is a list of bookings, can be empty. new_booking is an instance of the
	// 	   FlightBooking, HotelBooking or the DaytripBooking class.
	// After: new_booking has been added to the trip
	public void addToTrip(Booking new_booking) {
		Trip.add(new_booking);
	}

	// Usage: removeFromtrip(booked_item)
	// Before: booked_item is an instance of the FlightBooking, HotelBooking or the DaytripBooking class. 
	// 	   and it is already a part of the trip list. 
	public void removeFromTrip(Booking booked_item) {
		Trip.remove(booked_item);
	}

	// Usage: updateTrip(changed_booking)
	// Before: changed_booking is one of the bookings found in the Trip list. 
	// After: 
	public void updateTrip(Booking old_booking, Booking changed_booking) {
		
	}

	
	public List <Booking> payTrip() {
		List <Booking> flightBookings = new ArrayList<Booking>();
		List <Booking> hotelBookings = new ArrayList<Booking>();
		List <Booking> dayTripBookings = new ArrayList<Booking>();
		
		for (int i = 0; i < this.Trip.size(); i++) {
			if(Trip.get(i) instanceof FlightBooking) {
				flightBookings.add(Trip.get(i));
			} else if(Trip.get(i) instanceof HotelBooking) {
				hotelBookings.add(Trip.get(i));
			} else if (Trip.get(i) instanceof DaytripBooking){
				dayTripBookings.add(Trip.get(i));
			} else {
				
			}
		}
		return flightBookings;
	}
	
	public void printReceipt() {

		/* For extracting the information I forsee a loop similar to this one:
		for (int i = 0; i < Trip.size(); i++){
			Booking tmpbook = Trip.get(i);
			int totalTripPrice = totalTripPrice + tmpbook.price;
			
		}
		and then the values can be typecast to a String, which can then be concatenated in writing of the document
		String totalPrice = String.valueOf(totalTripPrice);
		*/

		// Figure out how to print information to pdf documents. This works for text documents.
	       try {
		    String text = "Afhverju heita tveir hÃ³pameÃ°limir Gunnar? Er allur frumleiki horfinn Ãºr heiminum? \nNei mÃ©r er bara spurn.";
		    BufferedWriter out = new BufferedWriter(new FileWriter("MyTrip.txt"));
		    out.write(text);
		    out.close();
		}
		catch (IOException e)
		{
		    System.out.println("Exception ");       
		}

		return ;
	}

}
