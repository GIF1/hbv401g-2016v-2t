//package metaSearchEngine

import java.io.*;
import java.util.*;

public class Package {

	// Declare class attributes
	protected List <Booking> Trip = new ArrayList<Booking>();


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
		// How to implement? Call methods of booking classes? 
		// Take in additional arguments to specify what changes are to be made? 
		Trip.set(old_booking, changed_booking); //???
	}

	// Will never be implemented
	// public void payTrip( Booking ...){}
		// Either add this to the booking classes or pay the total of all the bookings in the trip list. 
		// Add boolean variable isPaid? 

	
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
		    String text = "Afhverju heita tveir hópameðlimir Gunnar? Er allur frumleiki horfinn úr heiminum? \nNei mér er bara spurn.";
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
