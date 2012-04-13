import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;

public class TimerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Timer timer = new Timer(1*24*60*60, 30);

		System.out.println("Simulation starting from: " + timer.getCurrentTime());

		while(!timer.isMaxSimulationTimeExceeded()) {
			timer.advanceByTick();
			System.out.println("Tick #" + timer.getCurrentTickNumber() + ", which finished at time " + timer.getCurrentTime());
		}


		System.out.println("Simulation ended at Tick #" + timer.getCurrentTickNumber() + " finished at time " + timer.getCurrentTime());


		Calendar simulationClock = Calendar.getInstance();
		simulationClock.set(2000, 1, 1, 0, 0, 0); //NB: Arbitrary year *after* the 1970 epoch, to keep the date math simple (ie, positive milliseconds)

	}

}
