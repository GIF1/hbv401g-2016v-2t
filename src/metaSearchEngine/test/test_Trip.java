import java.util.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test_Trip {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight_mockobject mittflug = new Flight_mockobject("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		ArrayList<Booking> myTestBookings = new ArrayList<Booking>();
		myTestBookings.add(prufubokun);
		Package myTestTrip = new Package(myTestBookings, "The winner tests it all");
	}

}
