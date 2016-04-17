package metaSearchEngine.program;

import java.util.Date;

public abstract class HotelAbstract {

	private Date startTime;
	private Date endTime;
	private int[] priceRange;
	private String location;
	private String[] dealerInfo;

	private int price;
	private int area;
	private int numOfBeds;
	private int numOfBedrooms;

	public HotelAbstract(Date startTime, Date endTime, int[] priceRange, String location, String[] dealerInfo, int price, int area, int numOfBeds, int numOfBedrooms) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.priceRange = priceRange;
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
	public int[] getPriceRange() {return this.priceRange;}
	public String getLocation() {return this.Location; }
	public String[] getDealerInfo() {return dealerInfo;}
	
	// getters
	public int getPrice (){
		return this.price;
	}

	public int getArea(){
		return this.area;
	}

	public int getBeds(){
		return this.beds;
	}

	public int getBedrooms(){
		return this.bedrooms;
	}

	//Setter
	void setPriceRange(int[] priceRange) {this.priceRange = priceRange;}
	void setLocation (String Loc) {this.Location = Loc; }
	void setDealerInfo(String[] dealerInfo) {this.dealerInfo = dealerInfo;}
}
