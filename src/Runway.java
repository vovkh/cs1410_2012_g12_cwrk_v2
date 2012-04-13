
public class Runway extends Location{
	
	protected static final String locationName = "Runway";
	protected static final int locationSize = 1;
	protected boolean inUse;
	protected Aircraft aircraftUsingRunway;
	protected int timeInUse;
	
	public Runway() {
		super( locationName,locationSize );
		inUse = false; // default to the runway being available
		aircraftUsingRunway = null; // the aircraft using the runway, else null
		timeInUse = 0;
	}
	
	public void incrementNumberOfTimeInUse() {
		if( inUse ) {
			timeInUse++;
		}
	}
	
	public int getAircraftWaitingTimeOnRunway(){
		int waitingTime = 0;
		if(aircraftUsingRunway.getLocation() instanceof Hangar){
			waitingTime = aircraftUsingRunway.getTimeNeededToTakeOff();
		}
		else if (aircraftUsingRunway.getLocation() instanceof Airspace) {
			waitingTime = aircraftUsingRunway.getTimeNeededToLand();
		}
		else{
		}
		return waitingTime;
	}
	
	public void waitingTime(int tick){
			int waitTickTime = aircraftUsingRunway.getTickItArrivedOnRunway() + getAircraftWaitingTimeOnRunway();	
			if(tick >= waitTickTime) {
				setInUseFalse();
				if(aircraftUsingRunway.getLocation() instanceof Hangar) {
					System.out.println("Runway cleared - Aircraft finished taking off");
					removeFromLocation(aircraftUsingRunway);
				}
				if(aircraftUsingRunway.getLocation() instanceof Airspace) {
					System.out.println("Runway cleared - Aircraft finished landing");
					removeFromLocation(aircraftUsingRunway);
				}
			}
		}

	public Aircraft getAircraftUsingRunway(){
		return aircraftUsingRunway;
	}
		
	public boolean isInUse() {
		return inUse;
	}

	public void setAircraftUsingRunway( Aircraft aircraft ){
		aircraftUsingRunway = aircraft;
	}
	public void setInUseFalse(){
		inUse = false;
	}
	public void setInUse() {
		inUse = true;
	}
}
