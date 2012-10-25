import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FPButtonTest {

	FPButton fpb;
	@Before
	public void setUp() throws Exception {
		fpb=new FPButton(Direction.UP,null);
		assertEquals(Direction.UP,fpb.dir);
	}

	@Test
	public void testFPButton() {
		assertNotNull(this.fpb);
	}


}
