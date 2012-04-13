import java.util.Random;


public class Airport {
	
	private Airspace[] airspaces;
	private Hangar[] hangars;
	private Runway[] runways;
	private Workshop[] workshops;
	
	protected int queueType = 0;
	protected double BREAKDOWN_PROBABILITY = 0.0001;

	public Airport(int numberOfRunways) {
		int numberOfHangars = 1;
		int numberOfAirspaces = 1;
		int numberOfWorkshops = 1;
		createRunways(numberOfRunways);
		createHangars(numberOfHangars);
		createAirspaces(numberOfAirspaces);
		createWorkshops(numberOfWorkshops);		
	}

	
	
	public void setQueueType(int type){
		if(type > 0 && type < 3){
			queueType = type;
		}
	}
	public int getQueueType(){
		return queueType;
	}
	
	public Aircraft getNextAircraftToAct(){
		Aircraft nextAircraftToAct = null;
		if(queueType==2){
			if(getAirspace(0).getSize() > 0){
				nextAircraftToAct = getAirspace(0).getAircraftFromLocation(0);
				}
		
			else if(getHangar(0).getSize() > 0){
				nextAircraftToAct = getHangar(0).getAircraftFromLocation(0);
			}
			
		}
		if(queueType==1){
			getAirspace(0).sortAirspaceQueueBasedUponFuel();
			
		}
		return nextAircraftToAct;
	}
	
	public void assignAircraftToRunway(int tick) {
		
		if(getAvailableRunway().isInUse() == false) {
			System.out.println("|| "+getNextAircraftToAct().getAircraftName()+" is now assigned to Runway. ||");
			getAvailableRunway().setAircraftUsingRunway(getNextAircraftToAct());
			getAvailableRunway().waitingTime(tick);
			getAvailableRunway().incrementNumberOfTimeInUse();
			getNextAircraftToAct().act(tick);
			getAvailableRunway().setInUse();

		}
	}
	
	
	public void updateAiportPerTick(int tickSize, int currentTick){
		breakdownWhileWaitingToTakeOff(currentTick);
		checkRunways(currentTick);
		getAirspace(0).increaseFuelLevelsInAirspace(tickSize);
		
		if(getWorkshop(0).getSize() > 0) {
			getWorkshop(0).repairingTime(currentTick);
			
			for(int i = 0; i < getWorkshop(0).getSize(); i++) {
				Aircraft currentAircraft = getWorkshop(0).getAircraftFromLocation(i);
				if(currentAircraft.getBreakdown() == false) {
					currentAircraft.moveToLocation(getHangar(0));
				}
			}
		}
		
	}
	
	public void checkRunways(int tick) {
		for(int i = 0; i < runways.length; i++) {
			if(getRunway(i).isInUse()==true){
				getRunway(i).waitingTime(tick);
			}
		}
	}
	
	public void breakdownWhileWaitingToTakeOff(int currentTick) {
		Random random = new Random(Simulation.SEED);
		for(int i = 0; i < getHangar(0).getSize(); i++) {
			if(random.nextDouble() < BREAKDOWN_PROBABILITY) {		
				Aircraft brokenAircraft = getHangar(0).getAircraftFromLocation(i);
				brokenAircraft.breakdown(currentTick);
			}
		}
	}

	
	

	
	public void createAirspaces(int num){
		airspaces = new Airspace[num];
		for(int i = 0; i < airspaces.length; i++){
			airspaces[i] = new Airspace();
		}
	}
	public void createHangars(int num){
		hangars = new Hangar[num];
		for(int i = 0; i < hangars.length; i++){
			hangars[i] = new Hangar();
		}
	}
	public void createRunways(int num){
		runways = new Runway[num];
		for(int i = 0; i < runways.length; i++){
			runways[i] = new Runway();
		}
	}
	public void createWorkshops(int num){
		workshops = new Workshop[num];
		for(int i = 0; i < workshops.length; i++){
			workshops[i] = new Workshop();
		}
	}

	public Airspace getAirspace(int index) {
		return airspaces[0];
	}
	public Hangar getHangar(int index) {
		return hangars[0];
	}
	public Runway getRunway(int index) {
		return runways[0];
	}
	public Workshop getWorkshop(int index) {
		return workshops[0];
	}

	
	public Location getAvailableAirspace() {
		//Currently only using a single airspace
		//Method in place to allow for future expansion of the Airport
		return getAirspace(0);
	}
	public Hangar getAvailableHangar() {
		//Currently only using a single airspace
		//Method in place to allow for future expansion of the Airport
		return getHangar(0);
	}
	
	public Runway getAvailableRunway() {
		Runway availableRunway = null;
		for(int i = 0; i < runways.length; i++) {
			if(getRunway(i).isInUse() == false) {
				availableRunway = getRunway(i);
				return availableRunway;
			}
		}
		return availableRunway;
	}
	public Workshop getAvailableWorkshop() {
		//Currently only using a single airspace
		//Method in place to allow for future expansion of the Airport
		return getWorkshop(0);
	}



	public int getArrivalsQueueSize() {
		int queueSize = 0;
		for(int i = 0; i < airspaces.length; i++) {
			Airspace currentAirspace = getAirspace(i);
			queueSize += currentAirspace.getSize();
		}
		return queueSize;
	}
	
	public int getDeparturesQueueSize() {
		int queueSize = 0;
		for(int i = 0; i < hangars.length; i++) {
			Hangar currentHangar = getHangar(i);
			queueSize += currentHangar.getSize();
		}
		return queueSize;
	}
}
