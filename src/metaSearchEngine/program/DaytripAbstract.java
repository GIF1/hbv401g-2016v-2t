package metaSearchEngine.program;

import java.io.Serializable;
import java.util.Date;

public abstract class DaytripAbstract implements Serializable {
	
	//Attributes
	private Date startTime;
	private Date endTime;
	private String location;
	private int price;
	private int numParticipantsAvail;
	private String category;
	private String[] dealerInfo;
	private String name;
	private int IndivID;
	
	//Constructer
	public DaytripAbstract(Date startTime, Date endTime, String loc, int price, int numPar, String cat, String[] dealerInfo, String name) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = loc;
		this.price = price;
		this.numParticipantsAvail = numPar;
		this.category = cat;
		this.setDealerInfo(dealerInfo);
		this.name = name;
	}
	
	//Getters
	public Date getStartTime() {return startTime;}
	public Date getEndTime() {return endTime;}
	public String getLocation() {return location;}
	public int getPrice() {return price;}
	public int getNumParticipantsAvail() {return numParticipantsAvail;}
	public String getCategory() {return category;}
	public String[] getDealerInfo() {return dealerInfo;}
	public String getName() {return name;}
	public int getIndivID() {return IndivID;}
	
	//Setters
	void setStartTime(Date startTime) {this.startTime = startTime;}
	void setEndTime(Date endTime) {this.endTime = endTime;}
	void setLocation(String location) {this.location = location;}
	void setPrice(int price) {this.price = price;}
	void setNumParticipantsAvail(int numParticipantsAvail) {this.numParticipantsAvail = numParticipantsAvail;}
	void setCategory(String category) {this.category = category;}
	void setDealerInfo(String[] dealerInfo) {this.dealerInfo = dealerInfo;}
	void setName(String name) {this.name = name;}
	void setIndivID(int IndivID) {this.IndivID = IndivID;}
}
