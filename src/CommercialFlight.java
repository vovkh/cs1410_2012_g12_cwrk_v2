public class CommercialFlight extends FuelledAircraft{
	
	protected static final int timeNeededToTakeOff = 120;
	protected static final int timeNeededToLand = 180;
	protected static final String aircraftType = "Commercial Flight"; 
	protected static final int fuelMinimum = 1200; // 20 mins * 60
	protected static final int fuelRandomRange = 1200; // extra random range of 20min so that max could be 40 mins * 60

	public CommercialFlight(Airport airport, Location currentLocation) {
		super(aircraftType, airport, currentLocation, timeNeededToTakeOff, timeNeededToLand, fuelMinimum, fuelRandomRange);
		super.generateAmountOfFuel(fuelMinimum, fuelRandomRange);
	}
}
