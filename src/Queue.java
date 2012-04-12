import java.util.ArrayList;
import java.util.Collections;


public class Queue {
	private ArrayList<Aircraft> queue;
	
	/**
	 * 
	 */
	public Queue(){
		queue = new ArrayList<Aircraft>();
	}
	
	public void Sort() {
		/*	private void sortArrivalsQueue() {
		int n = arrivalsQueue.size();
		for ( int i = 0 ; i < n ; i ++) {
			for (int j = n -1 ; j > i ; j --) {
				if(arrivalsQueue.getFromQueue(j) instanceof FuelledAircraft) {
					FuelledAircraft currentAircraft = (FuelledAircraft)arrivalsQueue.getFromQueue(j);
					FuelledAircraft previousAircraft = (FuelledAircraft)arrivalsQueue.getFromQueue(j-1);
					if (currentAircraft.getCurrentFuelConsumptionLevel() > previousAircraft.getCurrentFuelConsumptionLevel()) {
						arrivalsQueue.swapAircraftInQueue(j-1, j);		  //swap positions of word j-1 and word j
					}
				}
				else if(arrivalsQueue.getFromQueue(j) instanceof UnfuelledAircraft) {
					//Move to back of queue

				}
			}
		}
	}
		 * */
		 
	}
	////////////
	
	
	public void swapAircraftInQueue(int n1, int n2){
		Collections.swap(queue,n1,n2);
	}
	
	
	/**
	 * Remove an aircraft from the queue
	 * @param aircraft The aircraft to be removed
	 */
	public void removeFromQueue(Aircraft aircraft) {
		queue.remove(aircraft);
	}
	
	/**
	 * Get an Aircraft from the queue
	 * @param index
	 */
	public Aircraft getFromQueue(int index) {
		return queue.get(index);
	}
	
	/**
	 * Add an aircraft to the queue
	 * @param aircraft aircraft to be added
	 */
	public void addToQueue(Aircraft aircraft) {
		queue.add(aircraft);
	}
	
	
	/**
	 * Get the size of the queue
	 * @return the size of the queue
	 */
	public int size() {
		return queue.size();
	}
	

	public boolean isAircraftTypeInQueue(String aircraftType){
		for(int i=0; i<queue.size(); i++) {
			if(this.getFromQueue(i).getAircraftType() == aircraftType) {
				return true;
			}
		}
		return false;
	}

	
	

}
