package metaSearchEngine.program;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Booking implements Serializable {
	// Define attributes of classes
	//protected User customer;
	protected String[] dealerInfo;
	protected int price;
	protected ArrayList<String> review = new ArrayList<String>();
	protected FlightBooking f = null;
	protected DaytripBooking d = null;
	protected HotelBooking h = null;
	
	// Method getInfo will be implemented in each subclass. 
	//public void getInfo();
	/*
	public User getCustomer() {
		return customer;
	}*/
	
	//public void setFlightBooking (FlightBooking f) {this.f = f;}
	//public void setDaytripBooking (DaytripBooking d) {this.d = d;}
	//public void setHotelBooking (HotelBooking h) {this.h = h;}
	
	public FlightBooking getFlightBooking() {return this.f;}
	public DaytripBooking getDaytripBooking() {return this.d;}
	public HotelBooking getHotelBooking() {return this.h;}
	
	public String[] getDealerInfo() {return this.dealerInfo;}
	public int getPrice() {return this.price;}
}
