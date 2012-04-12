
public abstract class UnfuelledAircraft extends Aircraft{

	public UnfuelledAircraft(String aircraftType, Airport airport, Location currentLocation, int timeNeededToTakeOff, int timeNeededToLand) {
		super(aircraftType, airport, currentLocation,  timeNeededToTakeOff,  timeNeededToLand);
	}

}
