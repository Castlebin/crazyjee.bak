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
		
		// 看不到执行。说明@AfterThrowing虽然可以处理方法抛出的异常，但是并不能完全处理该异常，
		// 异常依然会传播到上一级的调用者(本程序中是JVM，所以导致程序终止，从而下面的语句得不到执行)
		System.out.println("程序顺利结束");
	}
}
