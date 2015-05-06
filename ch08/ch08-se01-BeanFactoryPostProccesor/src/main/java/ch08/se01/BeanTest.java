package ch08.se01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.se01.service.Person;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// 获取名为person的bean
		Person p = ctx.getBean("chinese", Person.class);
		
		p.useAxe();
	}
}
