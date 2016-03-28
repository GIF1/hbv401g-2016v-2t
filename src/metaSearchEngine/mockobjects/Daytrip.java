package metaSearchEngine.mockobjects;

import java.util.ArrayList;

public class Daytrip {
	
	private String startTime;
	private String endTime;
	private String location;
	private int price;
	private int numParticipantsAvail;
	private String category;
	private ArrayList<String> dealerInfo = new ArrayList<String>();
	
	public Daytrip(String startTime, String endTime, String loc, int price, int numPar, String cat, ArrayList<String> dealerInfo) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = loc;
		this.price = price;
		this.numParticipantsAvail = numPar;
		this.category = cat;
		this.setDealerInfo(dealerInfo);
	}
	
	public String getStartTime() {return startTime;}
	public String getEndTime() {return endTime;}
	public String getLocation() {return location;}
	public int getPrice() {return price;}
	public int getNumParticipantsAvail() {return numParticipantsAvail;}
	public String getCategory() {return category;}
	public ArrayList<String> getDealerInfo() {return dealerInfo;}
	
	void setStartTime(String startTime) {this.startTime = startTime;}
	void setEndTime(String endTime) {this.endTime = endTime;}
	void setLocation(String location) {this.location = location;}
	void setPrice(int price) {this.price = price;}
	void setNumParticipantsAvail(int numParticipantsAvail) {this.numParticipantsAvail = numParticipantsAvail;}
	void setCategory(String category) {this.category = category;}
	void setDealerInfo(ArrayList<String> dealerInfo) {this.dealerInfo = dealerInfo;}
}
