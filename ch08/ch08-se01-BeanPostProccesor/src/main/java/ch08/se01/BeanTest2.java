package ch08.se01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import ch08.se01.service.Person;

// 使用ApplicationContext时Spring会自动注入bean后处理器，但是如果使用BeanFactory的话，就必须手动注册bean后处理器了
public class BeanTest2 {
	private static BeanFactory beanFactory;

	public static void main(String[] args) {
		// 使用beans_2.xml创建Resource对象
		Resource isr = new ClassPathResource("beans_2.xml");
		
		// 创建BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(isr);
		
		// 获取容器中的Bean后处理器
		BeanPostProcessor bp = (BeanPostProcessor)beanFactory.getBean("bp");
		// 注册bean后处理器到BeanFactory上
		beanFactory.addBeanPostProcessor(bp);
		
		// 获取名为person的bean
		Person p = beanFactory.getBean("chinese", Person.class);
		
		p.useAxe();
	}
}
