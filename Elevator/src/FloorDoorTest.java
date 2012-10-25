import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FloorDoorTest {

	FloorDoor fd;
	@Before
	public void setUp() throws Exception {
		fd=new FloorDoor();
	}

	@Test
	public void testFloorDoor() {
		assertNotNull(fd);
		assertEquals(fd.getState(),new Close());
	}

	@Test
	public void testOpenDoor() {
		fd.openDoor();
		assertEquals(fd.getState(),new Open());
	}

	@Test
	public void testCloseDoor() {
		fd.closeDoor();
		assertEquals(fd.getState(),new Close());
	}

	@Test
	public void testChangeState() {
		fd.changeState(new Open());
		assertEquals(fd.getState(),new Open());
	}

}
