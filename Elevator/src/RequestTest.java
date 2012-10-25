import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RequestTest {

	Request request;
	@Before
	public void setUp() throws Exception {
		request=new Request(Direction.UP,2);
		assertNotNull(request);
	}

	@Test
	public void testRequest() {
		request=new Request(Direction.UP,2);
		
		assertEquals(request.getDirection(),Direction.UP);
		assertEquals(request.getNo(),2);
	}

}
