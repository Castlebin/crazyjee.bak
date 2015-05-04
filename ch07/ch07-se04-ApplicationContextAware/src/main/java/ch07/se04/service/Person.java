package ch07.se04.service;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// 实现ApplicationContextAware或者BeanFactoryAware类，可以使Bean或得Spring容器，从而bean可以对Spring容器做出各种调用
public class Person implements ApplicationContextAware {
	// 使用成员变量来保存获得的BeanFactory，即Spring容器
	private ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;		
	}
	
	// 使用Spring容器，这里以在bean中使用Spring的国际化为例
	public void sayHi(String name) {
		// Locale的getDefault()方法返回计算机环境的默认Locale
		Locale locale = Locale.getDefault(Locale.Category.FORMAT);
		
		// 使用getMessage()方法返回本地化消息
		String hello = ctx.getMessage("hello",new String[]{name}, locale);
		
		System.out.println(hello);
	}
	
}
