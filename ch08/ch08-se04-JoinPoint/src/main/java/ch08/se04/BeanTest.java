package ch08.se04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.se04.service.HelloService;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloService helloService = ctx.getBean(HelloService.class);
		
		helloService.foo();
		helloService.addUser("heller", "123");
	}
}
