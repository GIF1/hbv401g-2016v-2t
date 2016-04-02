package metaSearchEngine.program;

import java.util.*;

public abstract class Booking {
	// Define attributes of classes
	protected String customer;
	protected ArrayList<String> dealerInfo = new ArrayList<String>();
	protected int price;
	protected ArrayList<String> review = new ArrayList<String>();

	// Method getInfo will be implemented in each subclass. 
	public abstract void getInfo();
	
	public String getCustomer() {
		return customer;
	}
}
