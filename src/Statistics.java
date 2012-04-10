
public class Statistics {
	protected int numberOfCrashes;
	protected int numberOftakeOffs;
	protected int numberOfLandings;
	
	public Statistics(){
		numberOfCrashes = 0;
		numberOftakeOffs = 0;
		numberOfLandings = 0;
	}
	
	public int getNumberOfCrashes(){
		return numberOfCrashes;
	}
	public int getNumberOfTakeOffs(){
		return numberOftakeOffs;
	}
	public int getNumberOfLandings(){
		return numberOfLandings;
	}

	public void incrementNumberOfTakeOffs(){
		numberOftakeOffs += 1;
	}	
	public void incrementNumberOfLandings(){
		numberOfLandings += 1;
	}
	
	public String toString(){
		return "";
	}

}
