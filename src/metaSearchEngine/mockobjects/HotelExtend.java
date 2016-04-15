package metaSearchEngine.mockobjects;

import metaSearchEngine.program.HotelAbstract;
import java.util.Date;

public class HotelExtend extends HotelAbstract{

	Date startTime;
	Date endTime;
	int numRoomSingleAvail;
	int numRoomDoubleAvail;
	int numRoomMultiAvail;
	int priceSingle;
	int priceDouble;
	int priceMulti;
	String Location;
	String[] dealerInfo;
	// .... possibly more
	
	//Constructor
	public HotelExtend(Date startTime, Date endTime, int numSingle, int numDouble, int numMulti, int priceSingle, int priceDouble, int priceMulti, String Loc, String[] dealerInfo /*, ...*/) {
		super(startTime, endTime, numSingle, numDouble, numMulti, priceSingle, priceDouble, priceMulti, Loc, dealerInfo);
		// ...
	}
}
