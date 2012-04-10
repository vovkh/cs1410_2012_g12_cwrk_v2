
public class Location{


	public int locationSize;
	protected Queue locationQueue; 
	protected String locationName;

	public Location(String locationName, int locationSize) {
		this.locationName = locationName;
		this.locationSize=locationSize;
		
	}

	public void addToLocation(Aircraft aircraft) {
		locationQueue.addToQueue(aircraft);
	}

	public void removeFromLocation(Aircraft aircraft) {
		locationQueue.removeFromQueue(aircraft);
	}

	public void setMaxLocationSize(int locationSize){
		this.locationSize=locationSize;
	}

	public Aircraft getAircraftFromLocationQueue(int index) {
		return locationQueue.getFromQueue(index);
	}

	public String getLocationName() {
		return locationName;
	}

	public int getLocationQueueSize() {
		return locationQueue.size();
	}

	public String toString() {
		//Return details of all aircraft in location as a string
		return "";
	}
}
