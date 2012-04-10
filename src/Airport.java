
public class Airport {
			
	private Airspace airspace;
	private Hangar hangar;
	protected Runway runway;
	private Workshop workshop;
	protected Queue arrivalsQueue;
	protected Queue departuresQueue;


	public Airport(){
			arrivalsQueue = new Queue();
			departuresQueue = new Queue();
			runway = new Runway();
			airspace = new Airspace();
			hangar = new Hangar();
			workshop = new Workshop();			
	}
	
	public Location getAvailableRunway(){
		
	}
	
	public Location getAvailableHangar(){
		
	}
	
	public Location getAvailableAirspace(){
		
	}
	
	public Location getAvailableWorkshop(){
		
	}
	
	public Queue getArrivalsQueue(){
		return arrivalsQueue;
	}
	
	public Queue getDeparturesQueue(){
		return departuresQueue;
	}
	
	public getNextAircraftToAct(){
	//look at arrivals/departures, queues
		//implement level 2 queuing
	}
	
	public void assignAircraftToRunway(int tick) {
		if(runway.getInUse() == false) {
			Aircraft aircraft = null;
			if(arrivalsQueue.size()>0){
				aircraft = arrivalsQueue.getFromQueue(0);
			}
			else {
				aircraft = departuresQueue.getFromQueue(0);
			}

			System.out.println("|| "+aircraft.getAircraftName()+" is now assigned to Runway. ||");
			runway.setInUse(true);
			runway.setAircraftUsingRunway(aircraft);
			aircraft.setTickItArrivedOnRunway(tick);
			waitingTimeOnRunway(aircraft,tick);

			aircraft.act(arrivalsQueue);

		}
	}
	public void checkRunway(int tick){
		if(runway.getInUse()==true){
			waitingTimeOnRunway(runway.getAircraftUsingRunway(), tick);
		}
	}
	
	public boolean isRunwayInUse(){
		runwayInUse = runway.getInUse();
		return runwayInUse;
	}

	public void addToDepartures(Aircraft aircraft) {
		aircraft.setLocation(hangar);
		departuresQueue.addToQueue(aircraft);

	}

	public void addToArrivals(Aircraft aircraft) {
		aircraft.setLocation(airspace);
		arrivalsQueue.addToQueue(aircraft);

	}
	public void removeAircraftFromDepartures(Aircraft aircraft) {
		departuresQueue.removeFromQueue(aircraft);
	}

	public void removeAircraftFromArrivals(Aircraft aircraft) {
		arrivalsQueue.removeFromQueue(aircraft);
	}

	public int getArrivalsSize() {	
		return arrivalsQueue.size();
	}
	public int getDeparturesSize() {	
		return departuresQueue.size();
	}


	
	
}
