package metaSearchEngine.program;

public class DaytripBooking extends Booking {

	// Declare class attributes:
	private DaytripAbstract daytrip;

	public DaytripBooking(DaytripAbstract daytripSearchResults) {
		daytrip = daytripSearchResults;
	}

	@Override
	public void getInfo() {
		System.out.println("Figure out some cool way to print this information");
	}

}
