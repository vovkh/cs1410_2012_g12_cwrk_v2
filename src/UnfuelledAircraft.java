
public abstract class UnfuelledAircraft extends Aircraft{

	public UnfuelledAircraft(String aircraftType, Location currentLocation, int timeTakenToTakeOff, int timeTakenToLand) {
		super(aircraftType, currentLocation,  timeNeededToTakeOff,  timeNeededToLand);
	}

}
