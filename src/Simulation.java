import java.util.Random;


public class Simulation {

	private Aircraft newAircraft;	
	private static Airport airport;
	private static Random random;
	private Statistics statistics;
	private String queueType;
	private Timer timer;
	private static int numOfAircraftsAdded;
	private static int SEED;
	private int simulationLength;
	private static int tickSize;
	private static double COMMERCIAL_FLIGHT_PROBABILITY; // 0.03 seems a good for safe p
	private static double GLIDER_PROBABILITY; // 0.2% chance of creating a glider
	private static double LIGHT_AIRCRAFT_PROBABILITY; // 0.5% chance of creating a light aircraft


	public void main(String[] args) throws InterruptedException {

		if (args==null){
			defaultSimulationProbabilities(); 
		}
		else{
			//roughly:
			//~~args.nextLine()
			//setSimulationLength(); 
			//setSimulationResolution();

		}

		random = new Random(SEED);
		timer = new Timer(simulationLength, tickSize);

		createAirport();
		int timeSeconds = 0;

		while(!timer.isMaxSimulationTimeExceeded()) {
			timer.advanceByTick();
			timeSeconds = timeSeconds + tickSize; 
			int currentTick = timeSeconds;
			System.out.println(getTime(currentTick));


			airport.checkRunway(currentTick);  
			airport.updatePerTick(tickSize);

			addAicraftToSimulation(); 
			if(newAircraft != null) {
				addAircraftToSimulation(airport, newAircraft, currentTick);	
				System.out.println("|| Arrivals queue size is "+airport.getArrivalsSize()+" || Departures queue size is "+airport.getDeparturesSize()+" ||");		
			} 

			if(airport.getArrivalsSize()>0 || airport.getDeparturesSize()>0 && airport.isRunwayInUse()==false){
				airport.assignAircraftToRunway(currentTick);

			}

			updateAirport();
		}
	}
	
	public void createAirport(){		
		airport = new Airport();
	}

	private void defaultSimulationProbabilities(){
		COMMERCIAL_FLIGHT_PROBABILITY = 0.2; // 0.03 seems a good for safe p
		GLIDER_PROBABILITY = 0.002; // 0.2% chance of creating a glider
		LIGHT_AIRCRAFT_PROBABILITY = 0.005; // 0.5% chance of creating a light aircraft
		SEED=42;
		simulationLength = 24*60*60; // 24*60*60; // 24hours; 
		tickSize = 30; // 30seconds;
	}

	public void setSimulationLength(int simulationLength){
		this.simulationLength=simulationLength;
	}

	public void setSimulationResolution(){

	}

	public void setCreationProbabilities(int COMMERCIAL_FLIGHT_PROBABILITY, int GLIDER_PROBABILITY, int LIGHT_AIRCRAFT_PROBABILITY){
		this.COMMERCIAL_FLIGHT_PROBABILITY = COMMERCIAL_FLIGHT_PROBABILITY;  //0.2; // 0.03 seems a good for safe p
		this.GLIDER_PROBABILITY = GLIDER_PROBABILITY; //0.002; // 0.2% chance of creating a glider
		this.LIGHT_AIRCRAFT_PROBABILITY = LIGHT_AIRCRAFT_PROBABILITY; //0.005; // 0.5% chance of creating a light aircraft
	}

	public String[] getCreationProbabilities(){
	
	}

	public void setRandomSeed(int seed){
		//hmm, why?.. A random will be random if you don't pass SEED. isn't it?
	}

	public int getRandomSeed(){
		
	}

	public void setQueueType(){

	}

	public String getQueueType(){
		return queueType;

	}

	public Aircraft addAicraftToSimulation(){
		Aircraft newAircraft = generateAircraftBasedOnProbability(random.nextDouble());
		return newAircraft;
	}


	public static void addAircraftToSimulation(Airport airport, Aircraft aircraft, int tick) {
		Random rand = new Random(SEED);
		numOfAircraftsAdded++;
		aircraft.setAircraftID(numOfAircraftsAdded);
		aircraft.setTickItArrivedOnQueue(tick);
		if(rand.nextBoolean()) { 
			airport.addToArrivals(aircraft);
			System.out.println("|| "+aircraft.getAircraftName()+" was added to Arrivals Queue."); // just testing
		}
		else {
			airport.addToDepartures(aircraft);
			System.out.println("|| "+aircraft.getAircraftName()+" was added to Departures Queue.");
		}

	}

	private static Aircraft generateAircraftBasedOnProbability(double probability) {
		Aircraft newAircraft;

		if(probability <= ( COMMERCIAL_FLIGHT_PROBABILITY )) {
			newAircraft = new CommercialFlight(airport);

		}
		else if(probability <= (LIGHT_AIRCRAFT_PROBABILITY)){
			newAircraft = new LightAircraft(airport);
		}
		else if(probability <= (GLIDER_PROBABILITY)) {
			newAircraft = new Glider(airport);
		}
		else {
			newAircraft = null;
		}

		return newAircraft;
	}

	private static String getTime(int tick){
		int seconds = tick;
		int minutes = seconds/60;
		int secondsRem = seconds%60;
		int minutesRem = minutes%60;
		int hours = minutes/60;

		String time = hours+":"+minutesRem+":"+secondsRem;
		return time;
	}
	
	public static void updateAirport(){
		/*	public void updatePerTick(int tick){     //***I guess this should go to Simulation***
		int i = 0 ;
		sortArrivalsQueue();
		while(i<arrivalsQueue.size()){
			if(arrivalsQueue.getFromQueue(i) instanceof FuelledAircraft){
				FuelledAircraft currentAircraft = (FuelledAircraft) arrivalsQueue.getFromQueue(i);
				currentAircraft.incrementFuelConsumptionLevel(tick);
				if(currentAircraft.checkFuelConsumptionLevel()==true){
					numberOfCrashes = numberOfCrashes + 1;
					arrivalsQueue.removeFromQueue(arrivalsQueue.getFromQueue(i));
				}
				else{
					System.out.println(arrivalsQueue.getFromQueue(i).getAircraftName()+" has current Fuel consumption of "+currentAircraft.getCurrentFuelConsumptionLevel());
				}
			}
			i = i + 1;
		}				
	}	
*/
		int totalNumberOfPlanesLeft = airport.getDeparturesSize()+airport.getArrivalsSize();
		System.out.println("###########################STATISTICS##########################");
		System.out.println("# Number of planes that landed: "+airport.getNumberOfLandings());
		System.out.println("# Number of planes that taken off: "+airport.getNumberOfTakeOffs());
		System.out.println("# Number of planes that crashed due to out of fuel: "+airport.getNumberOfCrashes());
		System.out.println("# Number of planes that was added to simulation: "+numOfAircraftsAdded);
		System.out.println("# Number of planes that did not land or take off: "+totalNumberOfPlanesLeft);
		System.out.println("# Number of planes that broke down during take off: ");
	}

}
