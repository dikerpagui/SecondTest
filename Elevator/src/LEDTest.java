import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LEDTest {

	LED led;
	@Before
	public void setUp() throws Exception {
		led=new LED();
	}

	@Test
	public void testLED() {
		assertNotNull(led);
	}

	@Test
	public void testChangeDirection() {
		led.changeDirection(Direction.DOWN);
		assertEquals(Direction.DOWN,led.getDirection());
		
		led.changeDirection(Direction.UP);
		assertEquals(Direction.UP,led.getDirection());
		
		led.changeDirection(Direction.STATIONARY);
		assertEquals(Direction.STATIONARY,led.getDirection());
	}

}
