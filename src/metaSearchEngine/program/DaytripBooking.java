package metaSearchEngine.program;

public class DaytripBooking extends Booking {

	// Declare class attributes:
	private Daytrip daytrip;

	public DaytripBooking(Daytrip daytripSearchResults) {
		daytrip = daytripSearchResults;
	}

	@Override
	public void getInfo() {
		System.out.println("Figure out some cool way to print this information");
	}

}
