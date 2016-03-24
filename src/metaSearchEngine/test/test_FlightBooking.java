package metaSearchEngine.test;

import metaSearchEngine.mockobjects.Flight;
import metaSearchEngine.program.*;

import java.util.*;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test_FlightBooking {
	ArrayList<String> wow_info = new ArrayList<String>();
	
	@Before
	public void setUp() {
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
	}

	@After
	public void tearDown() throws Exception {
		//Flight mittflug = null;
		//FlightBooking prufubokun = null;
		//ArrayList<String> wow_info = null;
	}

	@Test
	public void setCorrectSeatTest() {
		Flight mittflug = new Flight("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setSeat("33A");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWrongSeatTest() {
		Flight mittflug = new Flight("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setSeat("1");
	}
	
	@Test
	public void setCorrectLuggage() {
		Flight mittflug = new Flight("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setLuggage(3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWrongLuggage() {
		Flight mittflug = new Flight("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setLuggage(-3);
	}
	
	// Test flight number string format according to IATA airline designator standard: xx(a)n(n)(n)(n)(a)
	@Test(expected=IllegalArgumentException.class)
	public void emptyFlightNr() {
		Flight mittflug = new Flight("", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test
	public void validFlightNrCase1() {
		Flight mittflug = new Flight("AA1", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test
	public void validFlightNrCase2() {
		Flight mittflug = new Flight("A11", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test
	public void validFlightNrCase3() {
		Flight mittflug = new Flight("1A1", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test
	public void validFlightNrCase4() {
		Flight mittflug = new Flight("AAA1", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test
	public void validFlightNrCase5() {
		Flight mittflug = new Flight("AAA1A", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test
	public void validFlightNrCase6() {
		Flight mittflug = new Flight("AA123", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test
	public void validFlightNrCase7() {
		Flight mittflug = new Flight("AA1234A", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidFlightNrCase1() {
		Flight mittflug = new Flight("11", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidFlightNrCase2() {
		Flight mittflug = new Flight("AAAA", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidFlightNrCase3() {
		Flight mittflug = new Flight("AA11111", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug);
	}

	// Test departureTime string format. 
	@Test(expected=IllegalArgumentException.class)
	public void emptyDate() {
		Flight mittflug1 = new Flight("AAV321", "", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void wrongYear1() {
		Flight mittflug1 = new Flight("AAV321", "3016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongYear2() {
		Flight mittflug1 = new Flight("AAV321", "'16-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongMonth1() {
		Flight mittflug1 = new Flight("AAV321", "2016-13-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongMonth2() {
		Flight mittflug1 = new Flight("AAV321", "2016-00-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongDate1() {
		Flight mittflug1 = new Flight("AAV321", "2016-00-32 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongDate2() {
		Flight mittflug1 = new Flight("AAV321", "2016-00-00 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongTime1() {
		Flight mittflug1 = new Flight("AAV321", "2016-00-00 24:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongTime2() {
		Flight mittflug1 = new Flight("AAV321", "2016-00-00 31:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongTime3() {
		Flight mittflug1 = new Flight("AAV321", "2016-00-00 21:70:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void wrongTime4() {
		Flight mittflug1 = new Flight("AAV321", "2016-00-00 21:40:90", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test
	public void correctTime() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	// Test arrival location format:
	@Test(expected=IllegalArgumentException.class)
	public void emptiLoc() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void postnrLoc() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "551 Sauðárkrókur", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void longLoc() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", " Hann var mikill maður vexti og sterkur og allra manna best vígur. Hann hjó báðum höndum og skaut ef hann vildi og hann vó svo skjótt með sverði að þrjú þóttu á lofti að sjá. Hann skaut manna best af boga og hæfði allt það er hann skaut til. Hann hljóp meir en hæð sína með öllum herklæðum og eigi skemmra aftur en fram fyrir sig. Hann var syndur sem selur. Og eigi var sá leikur að nokkur þyrfti við hann að keppa og hefir svo verið sagt að engi væri hans jafningi. Hann var vænn að yfirliti og ljóslitaður, rétt nefið og hafið upp í framanvert, bláeygur og snareygur og rjóður í kinnum, hárið mikið, gult, og fór vel. Manna var hann kurteisastur, harðger í öllu, ráðhollur og góðgjarn, mildur og stilltur vel, vinfastur og vinavandur. Hann var vel auðigur að fé. ", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void shortLoc() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "KS", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test
	public void correctLoc() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	// Test arrival location in the same way as departure location
	@Test(expected=IllegalArgumentException.class)
	public void emptiLoc2() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void postnrLoc2() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "101 Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void longLoc2() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Hann var mikill maður vexti og sterkur og allra manna best vígur. Hann hjó báðum höndum og skaut ef hann vildi og hann vó svo skjótt með sverði að þrjú þóttu á lofti að sjá. Hann skaut manna best af boga og hæfði allt það er hann skaut til. Hann hljóp meir en hæð sína með öllum herklæðum og eigi skemmra aftur en fram fyrir sig. Hann var syndur sem selur. Og eigi var sá leikur að nokkur þyrfti við hann að keppa og hefir svo verið sagt að engi væri hans jafningi. Hann var vænn að yfirliti og ljóslitaður, rétt nefið og hafið upp í framanvert, bláeygur og snareygur og rjóður í kinnum, hárið mikið, gult, og fór vel. Manna var hann kurteisastur, harðger í öllu, ráðhollur og góðgjarn, mildur og stilltur vel, vinfastur og vinavandur. Hann var vel auðigur að fé. ", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void shortLoc2() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "RH", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test
	public void correctLoc2() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	// Test price input
	@Test(expected=IllegalArgumentException.class)
	public void negativePrice() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", -12000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void toohighPrice() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 100000001, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	@Test
	public void validPrice() {
		Flight mittflug1 = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 10000, wow_info);
		FlightBooking.testInput(mittflug1);
	}

	// Test trip dealer info
	@Test
	public void emptyDealerInfo() {
		ArrayList<String> dealer_info = new ArrayList<String>();
		//wow_info.add("Vsknr. 109354");
		Flight mittflug = new Flight("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 10000, dealer_info);
		FlightBooking.testInput(mittflug);
	}

}