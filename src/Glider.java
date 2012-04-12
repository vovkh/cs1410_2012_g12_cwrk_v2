
public class Glider extends UnfuelledAircraft{
	
	protected static final int timeNeededToTakeOff = 3 * 60; //3 minutes
	protected static final int timeNeededToLand = 4 * 60; //4 minutes
	protected static final String aircraftType = "Glider"; 

	
	public Glider(Airport airport, Location currentLocation){
		super(aircraftType, airport, currentLocation, timeNeededToTakeOff, timeNeededToLand);
	}
	
	public void takeOff(){
		//overwrite method	to town down
		//Must take off whilst being towed by a light aircraft
	}

}
