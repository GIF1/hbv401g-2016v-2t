package metaSearchEngine.test;

import metaSearchEngine.mockobjects.Flight;
import metaSearchEngine.program.*;

import java.util.*;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test_cases_sprint4 {
	ArrayList<String> wow_info = new ArrayList<String>();
	
	@Before
	public void setUp() {
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavík");
		wow_info.add("Kt. 451011-0220");
	}

	@After
	public void tearDown() throws Exception {
		//Flight mittflug = null;
		//FlightBooking prufubokun = null;
		//ArrayList<String> wow_info = null;
	}	
	@Test
	public void setCorrectLuggage() {
		Flight mittflug = new Flight("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setLuggage(3);
		assertEquals(prufubokun.luggage, 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWrongLuggage() {
		Flight mittflug = new Flight("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setLuggage(-3);
	}
}
