
package metaSearchEngine.program;

import java.io.Serializable;
import java.util.Date;

public abstract class HotelAbstract implements Serializable {

	private Date startTime;
	private Date endTime;
	private String location;
	private String[] dealerInfo;

	private int price;
	private int area;
	private int numOfBeds;
	private int numOfBedrooms;

	public HotelAbstract(Date startTime, Date endTime, String location, String[] dealerInfo, int price, int area, int numOfBeds, int numOfBedrooms) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.dealerInfo = dealerInfo;
		this.price = price;
		this.area = area;
		this.numOfBeds = numOfBeds;
		this.numOfBedrooms = numOfBedrooms;
	}

	//Getter
	public Date getStartTime() {return this.startTime;}
	public Date getEndTime() {return this.endTime;}
	public String getLocation() {return this.location; }
	public String[] getDealerInfo() {return dealerInfo;}
	
	// getters
	public int getPrice (){
		return this.price;
	}

	public int getArea(){
		return this.area;
	}

	public int getBeds(){
		return this.numOfBeds;
	}

	public int getBedrooms(){
		return this.numOfBedrooms;
	}

	//Setter
	void setLocation (String Loc) {this.location = Loc; }
	void setDealerInfo(String[] dealerInfo) {this.dealerInfo = dealerInfo;}
}
