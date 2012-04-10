public class CommertialFlight extends FuelledAircraft{
	
	protected static final int timeNeededToTakeOff = 120;
	protected static final int timeNeededToLand = 180;
	protected static final String aircraftType = "Commercial Flight"; 
	protected static final int fuelMinimum = 1200; // 20 mins * 60
	protected static final int fuelRandomRange = 1200; // extra random range of 20min so that max could be 40 mins * 60

	public CommertialFlight(String locationName) {
		super(aircraftType,  locationName, timeNeededToTakeOff, timeNeededToLand);
		super.generateAmountOfFuel(fuelMinimum, fuelRandomRange);
	}
}
