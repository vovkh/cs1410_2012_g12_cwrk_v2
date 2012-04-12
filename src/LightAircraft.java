
public class LightAircraft extends FuelledAircraft{
	
	protected static final int timeNeededToTakeOff = 120;
	protected static final  int timeNeededToLand = 180;
	protected static final int fuelMinimum = 10 * 60; // 20 mins * 60
	protected static final int fuelRandomRange = 10 * 60; // extra random range of 10min so that max could be 20 mins * 60 
	protected static final String aircraftType = "Light Aircraft"; 
	
	public LightAircraft(String aircraftType, Airport airport, Location currentLocation, int timeNeededToTakeOff,
			int timeNeededToLand) {
		super(aircraftType, airport, currentLocation, timeNeededToTakeOff, timeNeededToLand, fuelMinimum, fuelRandomRange);
		super.generateAmountOfFuel(fuelMinimum, fuelRandomRange);
	}

	public void moveToANewLocation() {
		// TODO Auto-generated method stub
		
	}

	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		
	}
}
