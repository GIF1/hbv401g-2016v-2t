package metaSearchEngine.mockobjects;

import metaSearchEngine.program.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class mockFlightSearch {
	private Date departureTime;
	private String departureLoc;
	private String arrivalLoc;
	private int[] priceRange;
	private boolean returnTrip;
	private int numSeats;
	private String seatClass;
	
	public static ArrayList<Flight> FlightSearch(FlightSearchCriteria flightCrit) {
		mockFlightSearch flightCriteria = new mockFlightSearch();
		flightCriteria.departureTime = flightCrit.getDepartureTime();
		flightCriteria.departureLoc = flightCrit.getDepartureLoc();
		flightCriteria.arrivalLoc = flightCrit.getArrivalLoc();
		flightCriteria.priceRange = flightCrit.getPriceRange();
		flightCriteria.returnTrip = flightCrit.getReturnTrip();
		flightCriteria.numSeats = flightCrit.getNumSeats();
		flightCriteria.seatClass = flightCrit.getSeatClass();
		
		ArrayList<Flight> flightsResults = searchFlights(flightCriteria);
		
		return flightsResults;
	}
	
	public static ArrayList<Flight> searchFlights(mockFlightSearch criteria) {
		ArrayList<FlightExtend> flights = flightMockConstructor();
		ArrayList<Flight> flightResults = new ArrayList<Flight>();
		
		for (int i=0; i<flights.size(); i++) {
			FlightExtend flight = flights.get(i);
			if (criteria.departureLoc == flight.departureLoc && criteria.arrivalLoc == flight.arrivalLoc) {
				Calendar criteriaCal = Calendar.getInstance();
				Calendar flightCal = Calendar.getInstance();
				criteriaCal.setTime(criteria.departureTime);
				flightCal.setTime(flight.departureTime);
				if (criteriaCal.get(Calendar.YEAR)==flightCal.get(Calendar.YEAR) && 
						criteriaCal.get(Calendar.MONTH)==flightCal.get(Calendar.MONTH) &&
						criteriaCal.get(Calendar.DAY_OF_MONTH)==flightCal.get(Calendar.DAY_OF_MONTH)) {
					if (flight.price >= criteria.priceRange[0] && flight.price <= criteria.priceRange[1]) {
						if (criteria.seatClass == "Economy") {
							if (criteria.numSeats <= flight.numSeatsEconomy) {
								flightResults.add(flight);
							}
						} else if (criteria.seatClass == "Comfort") {
							if (criteria.numSeats <= flight.numSeatsComfort) {
								flightResults.add(flight);
							}
						}
					}
				}
			} 
		}
		
		return flightResults;
	}
	
	public static ArrayList<FlightExtend> flightMockConstructor() {
		ArrayList<FlightExtend> flights = new ArrayList<FlightExtend>();
		
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavík");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		
		ArrayList<String> ice_info = new ArrayList<String>();
		wow_info.add("Icelandair");
		wow_info.add("Katrínartún 12 - 105 Reykjavík");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		
		//SimpleDateFormat duration = new SimpleDateFormat("HH:mm");
		//Date duration1 = duration.parse("02:15");
		
		@SuppressWarnings("deprecation")
		FlightExtend flight1 = new FlightExtend("AA123", new Date(2016-1900,7+1,15,22,30), 
				"Akureyri", "Reykjavík", 12000, 15, 5, "02:15", wow_info);
		flights.add(flight1);
		
		@SuppressWarnings("deprecation")
		FlightExtend flight2 = new FlightExtend("AB456", new Date(2016-1900,6+1,10,15,00), 
				"Egilsstaðir", "Vestmannaeyjar", 500000, 1, 3, "02:15", wow_info);
		flights.add(flight2);
		
		@SuppressWarnings("deprecation")
		FlightExtend flight3 = new FlightExtend("AC789", new Date(2016-1900,7+1,22,12,30), 
				"Reykjavík", "Akureyri", 12000, 10, 0, "02:15", ice_info);
		flights.add(flight3);
		
		return flights;
	}
}
