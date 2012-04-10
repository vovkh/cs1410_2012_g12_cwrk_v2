
public interface FlyingObject {

	public void act(Queue qu);

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

	public void land(Queue qu) ;

	public void moveToANewLocation();

	public void setArrivalTickOnQueue(int value);

	public void setArrivalTickOnRunway(int value) ;

	public void setLocation(Location location);	

	public void setTimeToLandAndTakeoff(int landTime, int takeoffTime);

	public void takeOff(Queue qu);

	public String toString();


}