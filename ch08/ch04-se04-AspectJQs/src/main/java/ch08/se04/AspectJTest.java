package ch08.se04;

import ch08.se04.service.Hello;
import ch08.se04.service.World;

public class AspectJTest {

	public static void main(String[] args) {
		Hello hello = new Hello();
		World world = new World();
		
		hello.addUser("悟空", "777888");
		hello.foo();
		
		world.bar();
	}
	
}
