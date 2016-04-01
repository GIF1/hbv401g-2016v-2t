package metaSearchEngine.mockobjects;

import java.util.ArrayList;

public abstract class Hotel {

	private int numRoomSingleAvail;
	private int numRoomDoubleAvail;
	private int numRoomMultiAvail;
	private int priceSingle;
	private int priceDouble;
	private int priceMulti;
	private String Location;
	private ArrayList<String> dealerInfo = new ArrayList<String>();

	public Hotel(int numSingle, int numDouble, int numMulti, int priceSingle, int priceDouble, int priceMulti, String Loc, ArrayList<String> dealerInfo) {
		this.numRoomSingleAvail = numSingle;
		this.numRoomDoubleAvail = numDouble;
		this.numRoomMultiAvail = numMulti;
		this.priceSingle = priceSingle;
		this.priceDouble = priceDouble;
		this.priceMulti = priceMulti;
		this.Location = Loc;
		this.dealerInfo = dealerInfo;
	}

	//Getters
	public int getNumRoomSingleAvail() {return this.numRoomSingleAvail; }
	public int getNumRoomDoubleAvail() {return this.numRoomDoubleAvail; }
	public int getNumRoomMultiAvail() {return this.numRoomMultiAvail; }
	public int getPriceSingle() {return this.priceSingle; }
	public int getPriceDouble() {return this.priceDouble; }
	public int getPriceMulti() {return this.priceMulti; }
	public String getLocation() {return this.Location; }
	public ArrayList<String> getDealerInfo() {return dealerInfo;}
	
	//Setters
	void setNumRoomSingleAvail (int numRoomsSingle) { this.numRoomSingleAvail = numRoomsSingle; }
	void setNumRoomDoubleAvail (int numRoomsDouble) { this.numRoomDoubleAvail = numRoomsDouble; }
	void setNumRoomMultiAvail (int numRoomsMulti) { this.numRoomMultiAvail = numRoomsMulti; }
	void setPriceSingle (int priceSingle) { this.priceSingle = priceSingle; }
	void setPriceDouble (int priceDouble) { this.priceDouble = priceDouble; }
	void setPriceMulti (int priceMulti) { this.priceMulti = priceMulti; }
	void setLocation (String Loc) {this.Location = Loc; }
	void setDealerInfo(ArrayList<String> dealerInfo) {this.dealerInfo = dealerInfo;}
}
