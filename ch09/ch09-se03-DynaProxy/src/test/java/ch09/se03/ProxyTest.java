package ch09.se03;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void testProxy() {
		Dog target = new GunDog();
		Dog dog = (Dog)MyProxyFactory.getProxy(target);
		
		dog.info();
		dog.run();
	}
	
}
