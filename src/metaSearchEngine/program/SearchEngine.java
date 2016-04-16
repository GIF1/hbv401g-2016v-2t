package metaSearchEngine.program;

import metaSearchEngine.mockobjects.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SearchEngine {
	
	public static ArrayList<FlightAbstract> flightSearch(FlightSearchCriteria flightSearch) {
		/*
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight flightResults = new Flight("AA123", flightSearch.departureTime, flightSearch.departureLoc, flightSearch.arrivalLoc, 100, wow_info);

		List<List<String>> results = flightResults.getResults();
		*/
		
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
		
		ArrayList<DaytripAbstract> daytripResults = DaytripSearcher.search(daytripSearch);
		
		return daytripResults;
	}
}
