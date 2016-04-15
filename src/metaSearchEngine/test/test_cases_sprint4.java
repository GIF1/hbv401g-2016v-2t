package metaSearchEngine.test;

import metaSearchEngine.mockobjects.*;
import metaSearchEngine.program.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test_cases_sprint4 {
	ArrayList<String> wow_info = new ArrayList<String>();
	FlightSearchCriteria newFlightSearch = new FlightSearchCriteria();
		

	@Before
	public void setUp() {
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavík");
		wow_info.add("Kt. 451011-0220");
	}

	@After
	public void tearDown() throws Exception {

	}	
	
	@Test
	public void setCorrectLuggage() {
		FlightAbstract flight = new FlightExtend("AA123", new Date(2016-1900,7+1,15,22,30), 
				"Akureyri", new Date(2016-1900,7+1,15,0,30), "Reykjavík", 12000,  
				new String[]{"13A", "13B", "11A"}, new String[]{"1A"}, wow_info);
		flight.set_seatNr(new String[]{"13A", "13B", "11A"});
		FlightBooking testbooking = new FlightBooking(flight, 1, "Sigurgeir");
		testbooking.setLuggage(3);
		assertEquals(testbooking.luggage, 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWrongLuggage() {
		FlightAbstract flight = new FlightExtend("AA123", new Date(2016-1900,7+1,15,22,30), 
				"Akureyri", new Date(2016-1900,7+1,15,0,30), "Reykjavík", 12000,  
				new String[]{"13A", "13B", "11A"}, new String[]{"1A"}, wow_info);
		flight.set_seatNr(new String[]{"13A", "13B", "11A"});
		FlightBooking testbooking = new FlightBooking(flight, 1, "Sigurgeir");
		testbooking.setLuggage(-3);
	}
	
	// Testing if an empty search criteria is stopped before calling the flight
	// search engine. This check is performed in the SearchEngine class.
	@Test(expected=IllegalArgumentException.class)
	public void emptyFlightSearch() {
		List<FlightAbstract> flightResults = SearchEngine.flightSearch(newFlightSearch);
	}
	
	// Testing if a normal search is performed that the results is a List of
	// class instances of FlightExtend, which extends the Flight class
	// if there are any flights that match else it should be an empty List.
	@Test
	public void flightSearch() {
		newFlightSearch.setDepartureTime(new Date(2016-1900,7+1,15));
		newFlightSearch.setDepartureLoc("Akureyri");
		newFlightSearch.setArrivalLoc("Reykjavík");
		newFlightSearch.setPriceRange(new int[]{10000,20000});
		newFlightSearch.setReturnTrip(false);
		newFlightSearch.setNumSeats(1);
		newFlightSearch.setSeatClass("Economy");
		List<FlightAbstract> flightResults = SearchEngine.flightSearch(newFlightSearch);
		if (flightResults.size()>0) {
			for (int i=0; i<flightResults.size(); i++) {
				assertThat(flightResults.get(i), instanceOf(FlightExtend.class));
			}
		} else {
			assertEquals(flightResults.size(),0);
		}
	}
	
	// Testing if a instance of a FlightBooking class is
	// delivered to the flight search engine when
	// flight is booked.
	@Test
	public void makeBooking1() {
		newFlightSearch.setDepartureTime(new Date(2016-1900,7+1,15));
		newFlightSearch.setDepartureLoc("Akureyri");
		newFlightSearch.setArrivalLoc("Reykjavík");
		newFlightSearch.setPriceRange(new int[]{10000,20000});
		newFlightSearch.setReturnTrip(false);
		newFlightSearch.setNumSeats(1);
		newFlightSearch.setSeatClass("Economy");
		List<FlightAbstract> flightResults = SearchEngine.flightSearch(newFlightSearch);

		FlightBooking testBooking = new FlightBooking(flightResults.get(0),1,"Gunnar");
		mockFlightBook bookedFlight = testBooking.bookFlight();
		
		assertThat(bookedFlight.flight, instanceOf(FlightBooking.class));
	}
	
	// Testing that the customer name from the Booking class
	// that is extended by FlightBooking is included in the
	// booking.
	@Test
	public void makeBooking2() {
		newFlightSearch.setDepartureTime(new Date(2016-1900,7+1,15));
		newFlightSearch.setDepartureLoc("Akureyri");
		newFlightSearch.setArrivalLoc("Reykjavík");
		newFlightSearch.setPriceRange(new int[]{10000,20000});
		newFlightSearch.setReturnTrip(false);
		newFlightSearch.setNumSeats(1);
		newFlightSearch.setSeatClass("Economy");
		List<FlightAbstract> flightResults = SearchEngine.flightSearch(newFlightSearch);

		FlightBooking testBooking = new FlightBooking(flightResults.get(0),1,"Gunnar");
		mockFlightBook bookedFlight = testBooking.bookFlight();
		
		assertEquals(bookedFlight.flight.getCustomer(), "Gunnar");
	}

}

