
public class Runway extends Location{
	
	protected static final String locationName = "Runway";
	protected static final int locationSize=1;
	protected boolean inUse;
	protected Aircraft aircraftUsingRunway;
	protected int timeInUse;
	
	public Runway() {
		super(locationName,locationSize);
		inUse = false; // default to the runway being available
		aircraftUsingRunway = null; // the aircraft using the runway, else null
		timeInUse = 0;
	}
	
	public void incrementTimeInUse() {
		if( inUse ) {
			timeInUse++;
		}
	}
	
	public Aircraft getAircraftUsingRunway(){
		return aircraftUsingRunway;
	}
		
	public boolean getInUse() {
		return inUse;
	}

	public void setAircraftUsingRunway(Aircraft aircraft){
		aircraftUsingRunway = aircraft;
	}

	public void setInUse() {
		inUse = true;
	}
}
