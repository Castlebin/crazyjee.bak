package ch09.se03;

import org.junit.Test;

public class FacadeTest {

	@Test
	public void testFacade() {
		Facade facade = new Facade();
		facade.serveFood();
	}
	
}
