public abstract class Aircraft implements FlyingObject{

	protected static String aircraftType;
	protected static int aircraftId;
	protected static Airport airport;
	public static Location currentLocation;
	protected static int timeNeededToLand;
	protected static int timeNeededToTakeOff;
	public int timeArrivedOnRunway; 
	public int timeArrivedOnQueue;
	protected boolean crashed;
	protected boolean breakdown;
	protected int timeAircraftBreaksdown;
	protected int waitingTimeInQueue;

	public Aircraft(String aircraftType, Airport airport, Location currentLocation, int timeNeededToTakeOff, int timeNeededToLand) {
		this.airport = airport;
		this.timeNeededToLand = timeNeededToLand;
		this.timeNeededToTakeOff = timeNeededToTakeOff;
		this.aircraftType = aircraftType;
		this.currentLocation=currentLocation;
		crashed = false;
		waitingTimeInQueue=0;

	}

	public void act(int timestamp) {

		if (currentLocation instanceof Hangar) {
			System.out.println("|| * "+this.getAircraftName()+" is taking off ||");
			//airport.incrementNumberOfTakeOffs();
			takeOff(timestamp);	

		} 
		else if (currentLocation instanceof Airspace) {
			System.out.println("|| * "+this.getAircraftName()+" is landing landed ||");
			//airport.incrementNumberOfLandings();
			land(timestamp);

		} 

		else if (currentLocation instanceof Workshop) {
			System.out.println("The plane is in Workshop");
		}
	}

	//if false when departing - move to workshop
	public void breakdown(int timeAircraftBreaksdown){
		this.timeAircraftBreaksdown=timeAircraftBreaksdown;	
		setBreakdown(true);		
		System.out.println(getAircraftName()+" broke down while waiting to take off.");
		this.moveToLocation(airport.getWorkshop(0));
	}
	
	
	public void moveToLocation (Location newLocation) {
		if(currentLocation != null) {
			currentLocation.removeFromLocation(this);
		}
		newLocation.addToLocation(this);
	}
	
	public void setBreakdown(boolean bool){
		this.breakdown = bool;
	}
	
	public boolean getBreakdown(){
		return this.breakdown;
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
	
	public int getTimeAircraftBrokeDown() {
		  return this.timeAircraftBreaksdown;
		 }

	public int getTickItArrivedOnRunway() {
		return timeArrivedOnRunway;
	}

	public int getTimeNeededToLand() {
		return timeNeededToLand;
	}

	public int getTimeNeededToTakeOff() {
		return timeNeededToTakeOff;
	}

	public int getTickItArrivedOnQueue() {
		return timeArrivedOnQueue;
	}

	public void land(int timestamp) {	
		Location runway = airport.getAvailableRunway();
		//nb: current location is likely to be airspace.. Doesn't matter too much as we are simply wanting to move the aircraft to the runway
		moveToLocation(runway);
		
		this.timeArrivedOnRunway = timestamp;
	}

	public void setAircraftID(int number){
		aircraftId = number;
	}

	public void setArrivalTickOnQueue(int value) {
		this.timeArrivedOnQueue = value;
	}

	public void setArrivalTickOnRunway(int value) {
		this.timeArrivedOnRunway = value;
	}
	
	public void setNewLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}	

	public void setTimeToLandAndTakeoff(int landTime, int takeoffTime){

	}

	public void takeOff(int timestamp) {	
		Location runway = airport.getAvailableRunway();
		//nb: current location is likely to be hangar.. Doesn't matter too much as we are simply wanting to move the aircraft to the runway
		currentLocation.removeFromLocation(this);	
		runway.addToLocation(this);

		this.timeArrivedOnRunway = timestamp;
	}

	public String toString() {
		return "";
	}
	
	public void wait(int tickTime){
		waitingTimeInQueue=waitingTimeInQueue+tickTime;
	}

}

