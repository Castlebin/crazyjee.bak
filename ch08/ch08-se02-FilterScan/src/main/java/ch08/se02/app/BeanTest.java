package ch08.se02.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String beanName : names) {
			System.out.println(beanName);
		}
	}
}
