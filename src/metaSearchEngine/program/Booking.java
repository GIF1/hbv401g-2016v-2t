package metaSearchEngine.program;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Booking implements Serializable {
	//Define attributes
	protected String[] dealerInfo;
	protected int price;
	protected ArrayList<String> review = new ArrayList<String>();
	protected FlightBooking f = null;
	protected DaytripBooking d = null;
	protected HotelBooking h = null;
	
	//Define getters
	public FlightBooking getFlightBooking() {return this.f;}
	public DaytripBooking getDaytripBooking() {return this.d;}
	public HotelBooking getHotelBooking() {return this.h;}
	public String[] getDealerInfo() {return this.dealerInfo;}
	public int getPrice() {return this.price;}
}
