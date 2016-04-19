package metaSearchEngine.mockobjects;

import metaSearchEngine.program.HotelAbstract;
import java.util.Date;

public class HotelExtend extends HotelAbstract{

	Date startTime;
	Date endTime;
	int price;
	String location;
	String[] dealerInfo;
	int area;
	int numOfBeds;
	int numOfBedrooms;
	// .... possibly more
	
	//Constructor
	public HotelExtend(Date startTime, Date endTime, String location, int price, int area, int numOfBeds, int numOfBedrooms, String[] dealerInfo) {
		super(startTime, endTime, location, dealerInfo, price, area, numOfBeds, numOfBedrooms);
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.price = price;
		this.area = area;
		this.numOfBeds = numOfBeds;
		this.numOfBedrooms = numOfBedrooms;
	}
}
