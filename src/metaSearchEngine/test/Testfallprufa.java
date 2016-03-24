import java.util.*;

public class Testfallprufa {
		static void testInput(Flight_mockobject fightSearchResult) {
		Flight_mockobject flight = fightSearchResult;
		if(flight==null) throw new IllegalArgumentException("Error: Search result class contains no value. ");
		String depTime = flight.get_depTime();
		
		if(depTime==null) throw new IllegalArgumentException("Error: Departure time is missing.");
		else if(depTime.length()!=19) throw new IllegalArgumentException("Error: Departure time of wrong length");
		// Note: It is still possible to set invalid departure time. 31st of febuary for example. 
		if(!depTime.matches("^2[01][0-9][0-9]-(0[0-9]|1[0-2])-([0-2][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) throw new IllegalArgumentException("Error: Departure time on uncorrect format. ");
		}


		public static void main(String[] args) {
			ArrayList<String> wow_info = new ArrayList<String>();
			wow_info.add("WOW air");
			wow_info.add("Katrínartún 12 - 105 Reykjavik");
			wow_info.add("Kt. 451011-0220");
			wow_info.add("Vsknr. 109354");
/*
// Test departureTime string format. 
@Test(expected=IllegalArgumentException.class)
	void emptyDate() {
		Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "", "Akureyri", "Reykjavík", 12000, wow_info);
	}
@Test(expected=IllegalArgumentException.class)
	void wrongYear() {
		Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "3016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
	}

@Test(expected=IllegalArgumentException.class)
	void wrongYear() {
		Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
	}



Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);
Flight_mockobject mittflug1 = new Flight_mockobject("AAV321", "2016-03-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);*/

Flight_mockobject mittflug = new Flight_mockobject("AAV321", "2016-13-22 23:30:00", "Akureyri", "Reykjavík", 12000, wow_info);


			testInput(mittflug);
		
		}
}
