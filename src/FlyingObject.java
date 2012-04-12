
public interface FlyingObject {

	public void act(int timestamp);

	public void breakdown();
	
	public int getAircraftID();
	
	public int getAircraftWaitingTimeOnRunway();

	public String getAircraftName();

	public String getAircraftType();

	public Location getLocation() ;

	public int getTickItArrivedOnRunway();

	public int getTimeNeededToLand() ;

	public int getTimeNeededToTakeOff();

	public int getTickItArrivedOnQueue();

	public void land(int timestamp) ;

	public void setNewLocation(Location currentLocation);

	public void setArrivalTickOnQueue(int value);

	public void setArrivalTickOnRunway(int value) ;

	public void setTimeToLandAndTakeoff(int landTime, int takeoffTime);

	public void takeOff(int timestamp);

	public String toString();


}