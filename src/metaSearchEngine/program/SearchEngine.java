package metaSearchEngine.program;

import metaSearchEngine.mockobjects.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//import hotel.HotelSearch;

import metaSearchEngine.mockobjects.*;

public class SearchEngine {
	
	public static ArrayList<FlightAbstract> flightSearch(FlightSearchCriteria flightSearch) {
	
		// Verify if there is any information
		if(flightSearch == null) {
			throw new IllegalArgumentException("Error: No search criteria has been entered");
		}
		
		// Verify departure time
		if(flightSearch.getDepartureTime() == null) {
			throw new IllegalArgumentException("Error: Search criteria is missing departure time");
		} else {
			Calendar depTime = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
			depTime.setTime(flightSearch.getDepartureTime());
			today.setTime(today.getTime());

			if (depTime.get(Calendar.YEAR) < today.get(Calendar.YEAR) || 
					(depTime.get(Calendar.YEAR) == today.get(Calendar.YEAR) && 
					depTime.get(Calendar.MONTH) < today.get(Calendar.MONTH)) ||
					(depTime.get(Calendar.YEAR) == today.get(Calendar.YEAR) && 
					depTime.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
					depTime.get(Calendar.DAY_OF_MONTH) < today.get(Calendar.DAY_OF_MONTH))) {
				throw new IllegalArgumentException("Error: Departure time is earlier than todays time");
			}
		}
		
		// Verify departure location
		if(flightSearch.getDepartureLoc()==null) {
			throw new IllegalArgumentException("Error: Departure location is missing.");
		}
		else if(flightSearch.getDepartureLoc().length()<3 || flightSearch.getDepartureLoc().length()>100) {
			throw new IllegalArgumentException("Error: Departure location is of wrong length");
		}
		else if(!flightSearch.getDepartureLoc().matches("^[A-Z].*") && !flightSearch.getDepartureLoc().matches("^[a-z].*")) {
			throw new IllegalArgumentException("Error: Departure location should start with a letter");
		}
		
		// Verify arrival location
		if(flightSearch.getArrivalLoc()==null) {
			throw new IllegalArgumentException("Error: Arrival location is missing.");
		}
		else if(flightSearch.getArrivalLoc().length()<3 || flightSearch.getArrivalLoc().length()>100) {
			throw new IllegalArgumentException("Error: Arrival location is of wrong length");
		}
		else if(!flightSearch.getArrivalLoc().matches("^[A-Z].*") && !flightSearch.getArrivalLoc().matches("^[a-z].*")) {
			throw new IllegalArgumentException("Error: Arrival location should start with a letter");
		}
		
		// Verify price range
		if (flightSearch.getPriceRange().length != 2) {
			throw new IllegalArgumentException("Error: Price range should contain two numbers");
		}
		
		// Verify seat class
		if (flightSearch.getSeatClass() == null) {
			throw new IllegalArgumentException("Error: No seat class has been chosen");
		} else if (!(flightSearch.getSeatClass() == "Economy" || flightSearch.getSeatClass() == "Comfort")) {
			throw new IllegalArgumentException("Error: Seat class should be either Economy or Comfort");
		}
		
		// Verify number of seats required
		if (flightSearch.getNumSeats() < 1) {
			throw new IllegalArgumentException("Error: Number of passangers should be at least 1 and"
					+ "not a negative number");
		}
		
		ArrayList<FlightAbstract> flightResults = mockFlightSearch.FlightSearch(flightSearch);
		
		return flightResults;
	}
	
	public static ArrayList<DaytripAbstract> daytripSearch(DayTripSearchCriteria daytripSearch) {
		
		// Verify if there is any information
		if(daytripSearch == null) {
			throw new IllegalArgumentException("Error: No search criteria has been entered");
		}

		if(daytripSearch.getStartTime().compareTo(daytripSearch.getEndTime()) > 0) {
			throw new IllegalArgumentException("Error: The trip can not end before it starts");
		}
		else {
			Calendar depTime = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
			depTime.setTime(daytripSearch.getStartTime());
			today.setTime(today.getTime());

			if (depTime.get(Calendar.YEAR) < today.get(Calendar.YEAR) || 
					(depTime.get(Calendar.YEAR) == today.get(Calendar.YEAR) && 
					depTime.get(Calendar.MONTH) < today.get(Calendar.MONTH)) ||
					(depTime.get(Calendar.YEAR) == today.get(Calendar.YEAR) && 
					depTime.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
					depTime.get(Calendar.DAY_OF_MONTH) < today.get(Calendar.DAY_OF_MONTH))) {
				throw new IllegalArgumentException("Error: Fool of a Took! You can not search for trips back in time!");
			}
		}

		if(daytripSearch.getLocation()==null) {
			throw new IllegalArgumentException("Error: Departure location is missing.");
		}

		if(daytripSearch.getPriceRange()==null) {
			throw new IllegalArgumentException("Error: Please select a price range.");
		}

		int[] tmpPriceRange = daytripSearch.getPriceRange();
		if(tmpPriceRange[0]>tmpPriceRange[1] || tmpPriceRange.length>2) {
			throw new IllegalArgumentException("Error: Invalid price-range. Please make sure that you select the lower limit first and then the higher limit.");
		}

		if(daytripSearch.getNumParticipants()<1) {
			throw new IllegalArgumentException("Error: You must search for a minimum of one seat.");
		}

		if(daytripSearch.getNumParticipants()<0) {
			throw new IllegalArgumentException("Error: You have not specified how many seats you would like.");
		}

		ArrayList<DaytripAbstract> daytripResults = DaytripSearcher.search(daytripSearch);
		
		return daytripResults;
	}

	public static ArrayList<HotelAbstract> HotelSearch(HotelSearchCriteria hotelSearch) {


		if(hotelSearch.getStartTime().compareTo(hotelSearch.getEndTime()) > 0) {
			throw new IllegalArgumentException("Error: The trip can not end before it starts");

		}
		else {
			Calendar depTime = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
			depTime.setTime(hotelSearch.getStartTime());
			today.setTime(today.getTime());

			if (depTime.get(Calendar.YEAR) < today.get(Calendar.YEAR) || 
					(depTime.get(Calendar.YEAR) == today.get(Calendar.YEAR) && 
					depTime.get(Calendar.MONTH) < today.get(Calendar.MONTH)) ||
					(depTime.get(Calendar.YEAR) == today.get(Calendar.YEAR) && 
					depTime.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
					depTime.get(Calendar.DAY_OF_MONTH) < today.get(Calendar.DAY_OF_MONTH))) {
				throw new IllegalArgumentException("Error: Fool of a Took! You can not search for trips back in time!");
			}
		}

		if(hotelSearch.getLocation()==null) {
			throw new IllegalArgumentException("Error: Departure location is missing.");
		}

		if(hotelSearch.getPriceRange()==null) {
			throw new IllegalArgumentException("Error: Please select a price range.");
		}

		int[] tmpPriceRange = hotelSearch.getPriceRange();
		if(tmpPriceRange[0]>tmpPriceRange[1] || tmpPriceRange.length>2) {
			throw new IllegalArgumentException("Error: Invalid price-range. Please make sure that you select the lower limit first and then the higher limit.");
		}

		// Structure of the searchWithAddress method of the HotelManager class: 
		// HotelManager.searchWithAddress(priceRange: int[] maxStars:int, street:String,  city:String, zipCode:String)
		ArrayList<HotelAbstract> HotelResults = HotelManager.searchWithAddress(hotelSearch.getPriceRange(), 0, hotelSearch.getLocation(), 
				hotelSearch.getStartTime(), hotelSearch.getEndTime());
		
		return HotelResults;
	}
	
}
