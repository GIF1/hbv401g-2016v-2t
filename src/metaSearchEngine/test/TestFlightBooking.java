import java.util.*;

public class TestFlightBooking {

	public static void main(String[] args){


		// Test class instantiation and attribute value assignment. 
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");

		Flight_mockobject mittflug = new Flight_mockobject("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		
		prufubokun.getInfo();
		

		// Test assignment logic of set-methods
		prufubokun.setSeat("33A");
		prufubokun.setLuggage(3);
		prufubokun.setFlightMeal(true);
		prufubokun.getInfo();
		//prufubokun.setSeat("Rangur strengur");
		//prufubokun.setLuggage(-4);
		//prufubokun.setLuggage("3");
		
		
	}
}
