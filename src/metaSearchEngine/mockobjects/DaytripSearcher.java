package metaSearchEngine.mockobjects;

import java.util.ArrayList;
import java.util.Date;

import metaSearchEngine.program.*;

public class DaytripSearcher {
	
	public static ArrayList<DaytripAbstract> search(DayTripSearchCriteria daytripCriteria) {
		ArrayList<DaytripAbstract> daytripResults = new ArrayList<DaytripAbstract>();
		
		String[] tripster = new String[]{"Tripster","555-5555","www.tripster.is"};
		String[] IceTravel = new String[]{"IceTravel","555-5556","www.icetravel.is"};
		
		//SimpleDateFormat duration = new SimpleDateFormat("HH:mm");
		//Date duration1 = duration.parse("02:15");
		@SuppressWarnings("deprecation")
		DaytripExtend daytrip1 = new DaytripExtend(new Date(2016-1900,7-1,15,22,30),
				new Date(2016-1900,7-1,15,0,30),"Reykjavík",10000,10,"Adventure",
				tripster,"NortherLighters");
		daytripResults.add(daytrip1);
		
		@SuppressWarnings("deprecation")
		DaytripExtend daytrip2 = new DaytripExtend(new Date(2016-1900,7-1,15,9,0),
				new Date(2016-1900,7-1,15,18,0),"Reykjavík",50000,32,"Side seeing",
				IceTravel,"Golden Circle");
		daytripResults.add(daytrip2);
		
		@SuppressWarnings("deprecation")
		DaytripExtend daytrip3 = new DaytripExtend(new Date(2016-1900,6-1,11,15,30),
				new Date(2016-1900,6-1,11,20,30),"Egilsstaðir",20000,2,"Chill",
				tripster,"Outsiders");
		daytripResults.add(daytrip3);
		
		return daytripResults;
	}
	
	
}
