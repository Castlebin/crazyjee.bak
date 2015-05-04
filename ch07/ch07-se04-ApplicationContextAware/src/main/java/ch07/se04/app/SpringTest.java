package ch07.se04.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch07.se04.service.Person;

public class SpringTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Person p = ctx.getBean("person", Person.class);
		p.sayHi("孙悟空");
	}
}
