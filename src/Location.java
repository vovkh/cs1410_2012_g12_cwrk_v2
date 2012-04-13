
public abstract class Location extends Queue {


	public int locationSize;
	protected String locationName;

	public Location( String locationName, int locationSize ) {
		this.locationName = locationName;
		this.locationSize = locationSize;	
	}

	public void addToLocation( Aircraft aircraft ) {
		if(getSize() >= getMaxLocationSize()){
			System.out.println("Can't hold anymore aircraft in this location");
		}
		else{
			addToQueue( aircraft );
		}
	}

	public void removeFromLocation( Aircraft aircraft ) {
		removeFromQueue( aircraft );
	}

	public void setMaxLocationSize( int locationSize ){
		this.locationSize = locationSize;
	}
	
	public int getMaxLocationSize(){
		return this.locationSize;
	}

	
	public String getLocationName() {
		return locationName;
	}

	public Aircraft getAircraftFromLocation( int index ) {
		return getFromQueue( index );
	}

	public String toString() {
		//Return details of all aircraft in location as a string
		return "";
	}
}
