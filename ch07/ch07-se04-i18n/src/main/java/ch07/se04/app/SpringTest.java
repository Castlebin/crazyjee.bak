package ch07.se04.app;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// Locale的getDefault()方法返回计算机环境的默认Locale
		Locale locale = Locale.getDefault(Locale.Category.FORMAT);
		
		// 使用getMessage()方法返回本地化消息
		String hello = ctx.getMessage("hello",new String[]{"悟空"}, locale);
		String now = ctx.getMessage("now",new Object[]{new Date()}, locale);
		
		System.out.println(hello);
		System.out.println(now);
	}
}
