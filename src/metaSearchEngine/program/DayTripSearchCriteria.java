/**
 * 
 */
package metaSearchEngine.program;

import java.util.Date;

public class DayTripSearchCriteria {
	
	// Attributes
	private String name;
	private String location;
	private Date startTime;
	private Date endTime;
	private int[] priceRange;
	private int numParticipants;
	private String category;
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public void setPriceRange(int[] priceRange) {
		this.priceRange = priceRange; 
	}
	
	public void setNumParticipants(int numParticipants) {
		this.numParticipants = numParticipants;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public int[] getPriceRange() {
		return priceRange;
	}
	
	public int getNumParticipants() {
		return numParticipants;
	}
	
	public String getCategory() {
		return category;
	}
}
