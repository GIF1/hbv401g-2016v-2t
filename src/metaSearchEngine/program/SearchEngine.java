package metaSearchEngine.program;

import metaSearchEngine.mockobjects.*;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
	
	static ArrayList<FlightExtend> flightSearch(FlightSearchCriteria flightSearch) {
		/*
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight flightResults = new Flight("AA123", flightSearch.departureTime, flightSearch.departureLoc, flightSearch.arrivalLoc, 100, wow_info);

		List<List<String>> results = flightResults.getResults();
		*/
		ArrayList<FlightExtend> flightResults = mockFlightSearch.FlightSearch(flightSearch);
		
		return flightResults;
	}
}
