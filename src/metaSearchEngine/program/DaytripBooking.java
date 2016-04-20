package metaSearchEngine.program;

public class DaytripBooking extends Booking {

	//Attributes
	private DaytripAbstract daytrip;
	private int numParticipants;
	
	//Constructor
	public DaytripBooking(DaytripAbstract daytripSearchResults) {
		this.daytrip = daytripSearchResults;
		this.price = daytripSearchResults.getPrice();
		this.dealerInfo = daytripSearchResults.getDealerInfo();
		this.d = this;
	}

	//Setters
	public void setNumParticipants(int numParticipants) {this.numParticipants = numParticipants;}
	
	//Getters
	public int getNumParticipants() {return this.numParticipants;}
	public DaytripAbstract getDayTrip() {return this.daytrip;}
}
