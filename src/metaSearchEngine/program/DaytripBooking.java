package metaSearchEngine.program;

public class DaytripBooking extends Booking {

	// Declare class attributes:
	private DaytripAbstract daytrip;
	private int numParticipants;

	public DaytripBooking(DaytripAbstract daytripSearchResults) {
		this.daytrip = daytripSearchResults;
		this.price = daytripSearchResults.getPrice();
		this.dealerInfo = daytripSearchResults.getDealerInfo();
		this.d = this;
	}

	public void setNumParticipants(int numParticipants) {this.numParticipants = numParticipants;}
	
	public int getNumParticipants() {return this.numParticipants;}
	public DaytripAbstract getDayTrip() {return this.daytrip;}
	/*
	@Override
	public void getInfo() {
		System.out.println("Figure out some cool way to print this information");
	}*/

}
