package ch07.se04.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch07.se04.event.EmailEvent;

public class SpringTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// 创建一个EmailEvent事件
		EmailEvent event = new EmailEvent("test", "heller@google.com", "Hello, Google!");
		
		// 向容器发布事件
		ctx.publishEvent(event);
	}
}
