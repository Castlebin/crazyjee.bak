package ch07.se02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch07.se02.service.Person;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// 获取名为person的bean
		Person p = ctx.getBean("person", Person.class);
		
		p.useAxe();
	}
}
