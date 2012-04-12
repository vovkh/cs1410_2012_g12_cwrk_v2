import java.util.Random;


public abstract class FuelledAircraft extends Aircraft {

	protected int currentFuelLevel;
	protected int originalFuelLevel;
	protected int currentFuelConsumptionLevel = 0;

	public FuelledAircraft(
			String aircraftType, 
			Airport airport, 
			Location currentLocation, 
			int timeNeededToTakeOff, 
			int timeNeededToLand,
			int fuelMinimum,
			int fuelRandomRange
			) 
	{
		super(aircraftType, airport, currentLocation, timeNeededToTakeOff, timeNeededToLand);
		generateAmountOfFuel(fuelMinimum, fuelRandomRange);
	}

	public int getFuelLevel(){
		return currentFuelLevel;
	}

	
	protected int generateAmountOfFuel(int fuelMinimum, int fuelRandomRange){
	//currentFuelLevel
		//between 20-40min	
			// minLevel+randomNum=originalFuelLevel;
			//eg. 20+random(20)=30 +-10
		Random rand = new Random(Simulation.SEED);
		
		
		//rand.nextInt(n) returns a value in the range [0, n-1] exclusive of n. 
		//Thus, must add 1 to shift the range to [1, n]   
		return fuelMinimum + (rand.nextInt(fuelRandomRange + 1));
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
