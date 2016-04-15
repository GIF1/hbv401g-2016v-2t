package metaSearchEngine.mockobjects;

import metaSearchEngine.program.DaytripAbstract;
import java.util.Date;

public class DaytripExtend extends DaytripAbstract{

	Date startTime;
	Date endTime;
	String location;
	int price;
	int numParticipantsAvail;
	String category;
	String[] dealerInfo;
	// .... possibly more
	
	//Constructor
	public DaytripExtend(Date startTime, Date endTime, String loc, int price, int numParticipants, String category, String[] dealerInfo /*, ...*/) {
		super(startTime, endTime, loc, price, numParticipants, category, dealerInfo);
		// ...
	}
}