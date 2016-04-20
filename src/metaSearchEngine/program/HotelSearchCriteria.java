/**
 * 
 */
package metaSearchEngine.program;

import java.util.Date;

public class HotelSearchCriteria {
	
	// Attributes
	private Date startTime;
	private Date endTime;
	private int[] priceRange;
	private String location;

	//Setters
	public void setStartTime(Date startTime) {this.startTime = startTime;}
	public void setEndTime(Date endTime) {this.endTime = endTime;}
	public void setPriceRange(int[] priceRange) {this.priceRange = priceRange;}
	public void setLocation(String location) {this.location = location;}

	//Getters
	public Date getStartTime() {return startTime;}
	public Date getEndTime() {return endTime;}
	public int[] getPriceRange() {return priceRange;}
	public String getLocation() {return location;}
}
