import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EPButtonTest {

	EPButton epb;
	@Before
	public void setUp() throws Exception {
		epb=new EPButton(1,null);
		assertEquals(epb.id,1);
	}

	@Test
	public void testEPButton() {
		assertNotNull(this.epb);
	}


}
