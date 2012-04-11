
public abstract class FuelledAircraft extends Aircraft{

	protected int currentFuelLevel;
	protected int originalFuelLevel;
	protected int currentFuelConsumptionLevel = 0;

	public FuelledAircraft(String aircraftType, Location currentLocation, int timeTakenToTakeOff, int timeTakenToLand) {
		super(aircraftType, currentLocation, timeNeededToTakeOff, timeNeededToLand);
		generateAmountOfFuel();
	}

	public int getFuelLevel(){
		return currentFuelLevel;
	}

	protected int generateAmountOfFuel(int minLevel, int randomNum){
	//currentFuelLevel
		//between 20-40min	
			// minLevel+randomNum=originalFuelLevel;
			//eg. 20+random(20)=30 +-10
	}
	
	public void incrementFuelConsumptionLevel(int tickSize){
		currentFuelConsumptionLevel = currentFuelConsumptionLevel + tickSize;
	}
	public int getFuelConsumptionLevel(){
		return currentFuelConsumptionLevel;
	}
	public boolean checkIfEnoughFuel(){
				
		boolean hasPlaneCrashed = false;
		if(getFuelConsumptionLevel()> getFuelLevel()){
			System.out.println(getAircraftName()+" has CRASHED because it was out of fuel");
			hasPlaneCrashed = true;
			super.crash();
		}
		return hasPlaneCrashed;
		
	}
	
	
	
}
