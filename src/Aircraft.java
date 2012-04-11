
public abstract class Aircraft implements FlyingObject{

	protected static String aircraftType;
	protected static int aircraftId;
	public static Location currentLocation;
	protected static int timeNeededToLand;
	protected static int timeNeededToTakeOff;
	public int tickItArrivedOnRunway; 
	public int tickItArrivedOnQueue;
	protected boolean crashed;

	public Aircraft(String aircraftType, Location currentLocation, int timeNeededToTakeOff, int timeNeededToLand) {
		this.timeNeededToLand = timeNeededToLand;
		this.timeNeededToTakeOff = timeNeededToTakeOff;
		this.aircraftType = aircraftType;
		this.currentLocation=currentLocation;
		crashed = false;

	}

	public void act(Queue qu) {

		if (currentLocation instanceof Hangar) {
			System.out.println("|| * "+this.getAircraftName()+" is taking off ||");
			//airport.incrementNumberOfTakeOffs();
			takeOff(qu);	

		} 
		else if (currentLocation instanceof Airspace) {
			System.out.println("|| * "+this.getAircraftName()+" is landing landed ||");
			//airport.incrementNumberOfLandings();
			land(qu);

		} 

		else if (currentLocation instanceof Workshop) {
			System.out.println("The plane is in Workshop");
		}
	}

	public void breakdown(){
		//if false when departing - move to workshop
	}

	public void crash(){
		crashed=true;
	}	

	public int getAircraftID(){
		return this.aircraftId;
	}

	public int getAircraftWaitingTimeOnRunway(){
		int waitingTime = 0;
		if(currentLocation instanceof Hangar){
			waitingTime = getTimeNeededToTakeOff();
		}
		else if (currentLocation instanceof Airspace) {
			waitingTime = getTimeNeededToLand();
		}
		else{
		}
		return waitingTime;
	}

	public String getAircraftName(){
		String str = getAircraftType()+" "+getAircraftID();
		return str;
	}

	public String getAircraftType() {
		return this.aircraftType;
	}

	public Location getLocation() {
		return this.currentLocation;
	}

	public int getTickItArrivedOnRunway() {
		return tickItArrivedOnRunway;
	}

	public int getTimeNeededToLand() {
		return timeNeededToLand;
	}

	public int getTimeNeededToTakeOff() {
		return timeNeededToTakeOff;
	}


	public int getTickItArrivedOnQueue() {
		return tickItArrivedOnQueue;
	}


	public void land(Queue qu) {	
		qu.removeFromQueue(this);	
	}

	private void setAircraftID(int number){
		aircraftId = number;
	}

	public void setArrivalTickOnQueue(int value) {
		this.tickItArrivedOnQueue = value;
	}

	public void setArrivalTickOnRunway(int value) {
		this.tickItArrivedOnRunway = value;
	}
	
	public void setNewLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
		//move itself from current location and assign itself to a new location

		/*
		 * 	private void waitingTimeOnRunway(Aircraft aircraft, int tick){
		int waitTickTime = aircraft.getTickItArrivedOnRunway() + aircraft.getAircraftWaitingTimeOnRunway();	
		if(tick >= waitTickTime) {
			runway.setInUse(false);

			if(aircraft.getLocation() instanceof Hangar) {
				//Finished taking off
				System.out.println("Runway cleared - Aircraft finished taking off");
			}
			if(aircraft.getLocation() instanceof Airspace) {
				//Finished taking off
				System.out.println("Runway cleared - Aircraft finished landing");
			}
		}
	}
		 * 
		 */

	}	

	public void setTimeToLandAndTakeoff(int landTime, int takeoffTime){

	}

	public void takeOff(Queue qu) {	
		qu.removeFromQueue(this);                                                	
	}

	public String toString() {
		return "";
	}


}
