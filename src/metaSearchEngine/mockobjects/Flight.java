package metaSearchEngine.mockobjects;

import java.util.*;

public abstract class Flight {
	private final String flightNr;
	private String departureTime;
	private String departureLoc;
	private int price;
	private String arrivalLoc;
	private ArrayList<String> dealerInfo = new ArrayList<String>();

	public Flight(String flightNr, String departureTime, String departureLoc, String arrivalLoc, int price, ArrayList<String> dealerInfo) {
		this.flightNr = flightNr;
		this.departureTime = departureTime;
		this.departureLoc = departureLoc;
		this.arrivalLoc = arrivalLoc;
		this.price = price;
		this.dealerInfo = dealerInfo;
	}
	
	public List<List<String>> getResults() {
		List<List<String>> results = new ArrayList<List<String>>();
		List<String> resultsRow1 = new ArrayList<String>();
		List<String> resultsRow2 = new ArrayList<String>();
		List<String> resultsRow3 = new ArrayList<String>();
		
		resultsRow1.add(flightNr);
		resultsRow1.add(departureLoc);
		resultsRow1.add(arrivalLoc);
		resultsRow1.add(departureTime);
		resultsRow1.add(String.valueOf(price));
		resultsRow1.add(dealerInfo.get(0));
		
		resultsRow2.add("AA123");
		resultsRow2.add("Ísafjörður");
		resultsRow2.add("Vestmannaeyjar");
		resultsRow2.add("2016-03-22 23:30:00");
		resultsRow2.add("100000");
		resultsRow2.add("Icelandair");
		
		resultsRow3.add("AA123");
		resultsRow3.add("Ísafjörður");
		resultsRow3.add("Vestmannaeyjar");
		resultsRow3.add("2016-03-22 23:30:00");
		resultsRow3.add("100000");
		resultsRow3.add("Icelandair");
		
		results.add(resultsRow1);
		results.add(resultsRow2);
		results.add(resultsRow3);
		
		return results;
	}

	// Get methods for all the attributes
	public int get_price() {return price; }
	public String get_depTime() { return departureTime; }
	public String get_depLoc() { return departureLoc; }
	public String get_arrivLoc() { return arrivalLoc; }
	public ArrayList<String> get_dealerInfo() { return dealerInfo; }
	public String get_flightNr() {return flightNr; }
}
