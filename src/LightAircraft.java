
public class LightAircraft extends FuelledAircraft{
	
	protected static final int timeNeededToTakeOff = 120;
	protected static final  int timeNeededToLand = 180;
	protected static final int fuelMinimum = 10 * 60; // 20 mins * 60
	protected static final int fuelRandomRange = 10 * 60; // extra random range of 10min so that max could be 20 mins * 60 
	protected static final String aircraftType = "Light Aircraft"; 
	
	public LightAircraft(String aircraftType, String locationName, int timeTakenToTakeOff,
			int timeTakenToLand) {
		super(aircraftType,  locationName, timeNeededToTakeOff, timeNeededToLand);
		super.generateAmountOfFuel(fuelMinimum, fuelRandomRange);
	}
}
