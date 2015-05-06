package ch08.se01.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import ch08.se01.service.impl.Chinese;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Bean后处理器在初始化之前对" + beanName + "进行增强处理…");
		// 返回的处理后的Bean实例，就是容器中实际使用的Bean实例
		// 因此该实例甚至完全可以是一个新的bean，甚至可以与原来的bean没有任何关系
		// 此处我们是原样返回，不做改变
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Bean后处理器在初始化后对" + beanName + "进行增强处理…");
		// 假设该Bean是Chinese类的实例
		if(bean instanceof Chinese) {
			// 修改该bean属性
			Chinese c = (Chinese)bean;
			c.setName("疯狂Java讲义");
		}
		
		return bean;
	}

}
