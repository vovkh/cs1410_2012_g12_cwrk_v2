import java.util.Calendar;

public class Timer {

	private Calendar simulationClock;
	private Calendar maxSimulationTime;
	private int tickSize_seconds;
	private int maxSimulationTime_secs;

	
	/**
	 * Constructor for the Timer class. 
	 * @param _simulation A link back to the simulation that created this Timer
	 * @param _maxSimulationTime_secs the number of seconds that the simulation may run for. NB: 24hrs = 86400 seconds
	 * @param _tickSize_secs the length of each 'tick' in seconds
	 */
	public Timer(int _maxSimulationTime_secs, int _tickSize_secs) {
		this.maxSimulationTime_secs = _maxSimulationTime_secs;
		this.tickSize_seconds = _tickSize_secs;
		createTimers();
	}
	

	
	/**
	 * Checks whether the maximum run time of the timer has been reached or exceeded.
	 * @return boolean: true if the maximum run time of the simulation has been reached or exceeded, else returns false;
	 */
	public boolean isMaxSimulationTimeExceeded() {
		if( simulationClock.getTimeInMillis() >= maxSimulationTime.getTimeInMillis() ) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Advance the current timer by the tick size given during the creation of the Timer 
	 */
	public void advanceByTick() {
		simulationClock.add(Calendar.SECOND, tickSize_seconds);		
	}
	

	/**
	 * Get a string representation of the given Calendar object to be used in the logging calls. 
	 * NB: Only works in the DATE range ([1-31] - 1) as strange things may occur when the Calendar "rolls over" to the next month
	 * 
	 * @param calendar The Calendar object to be converted to a String.
	 * @return A string representation in the format dd"d" hh:mm:ss
	 */
	private String calendarToString_LogFile(Calendar calendar) {
		String currentTime = "";
		
		//IGNORE THE COMMENTED BLOCK BELOW - WAS CREATED BEFORE SEEING THE String.format() method
		/**
		String dd,hh,mm,ss = "";
		
		int d = calendar.get(Calendar.DATE) - 1; //Subtract 1 as we want it to be zero-indexed (ie, start from day 0).
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		
		//Convert to "padded" values using the String formatter, where values [0-9] are prepended with a 0;
		//See the 
		dd = String.format("%02d", d);
		hh = String.format("%02d", h);
		mm = String.format("%02d", m);
		ss = String.format("%02d", s);
		
		currentTime += dd+"d "+ hh+":" + mm+"::" + ss;	
		**/
		
		currentTime = String.format("%td", calendar) + "d " + String.format("%tT", calendar);
		
		//xd h:m::s
		return currentTime;
	}
	
	
	/**
	 * Return a string representation of how long the simulation has been running for
	 * @return A string representation in the format dd"d" hh:mm::ss
	 */
	public String getCurrentTime() {
		return calendarToString_LogFile(simulationClock);
	}

	
	/**
	 * Get the index of the current "tick". 
	 * Note that, assuming a 30-second "tick size":
	 * 00d 00:00::00 to 00d 00:00::30 is tick #1
	 * 00d 00:00::30 to 00d 00:01::00 is tick #2
	 * 
	 * Therefore, to calculate the current tick, we divide the number of seconds elapsed and round up to the next integer.
	 * 
	 * @return an integer representing the integer of the current tick. 
	 */
	public int getCurrentTickNumber() {
		Calendar blankCalendar = newCalendar();
		double secsElapsed = (simulationClock.getTimeInMillis() - blankCalendar.getTimeInMillis()) / 1000;
		
		int tickNumber = (int) Math.ceil(secsElapsed / this.tickSize_seconds);
		return tickNumber;		
	}
	
	
	
	

	/**
	 * Create the objects used for tracking the timing.
	 */
	private void createTimers() {
		simulationClock = newCalendar(); 

		this.maxSimulationTime = newCalendar(); //NB: Arbitrary year *after* the 1970 epoch, to keep the date math simple (ie, positive milliseconds)
		this.maxSimulationTime.add(Calendar.SECOND, maxSimulationTime_secs);
	}
	
	/**
	 * Utility function to create a new "blank" calendar object.
	 * Used as a blank base for all other times to work from. 
	 * Ideally it would be set to 0000/00/00 00:00::00 but this is not a valid time / date, so the arbitrary date of Jan 1st in the year 2000 is used instead.
	 * 
	 * It *should* not matter however, since all other times *should* be calculated as relative to this date.
	 * 
	 * @return Calendar object set to 2000/Jan/01 @ 00:00::00
	 */
	private Calendar newCalendar() {
		Calendar newCalendar = Calendar.getInstance();
		//NB: Arbitrary year *after* the 1970 epoch, to keep the date math simple (ie, positive milliseconds)
		// Equivalent to 2000/Jan/01 00:00::00
		newCalendar.set(2000, 1, 1, 0, 0, 0); 
		
		return newCalendar;
	}

	
	/**
	 * Function to set the size of the "ticks"
	 * @param tickSize_secs
	 */
	public void setTickSize(int tickSize_secs) {
		this.tickSize_seconds = tickSize_secs;
	}
	
	/**
	 * Get the size of each "tick" period
	 * @return integer representing the number of seconds that each "tick" runs for
	 */
	public int getTickSize() {
		return tickSize_seconds;
	}
	
	/**
	 * Method used to set how long the simulation may run for
	 * @param maxSimulationTime_secs an integer representing the maximum time that the simulation may run for. NB: 24hrs = 24*60*60 = 86400 seconds 
	 */
	public void setMaxSimulationTime(int maxSimulationTime_secs) {
		this.maxSimulationTime_secs = maxSimulationTime_secs;
	}
	
	
	
}
