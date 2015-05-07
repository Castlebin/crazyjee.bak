package ch08.se03.app;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

import ch08.se03.domain.TestBean;

public class ResourceLoaderAwareTest {
	
	public static void main(String[] args) throws DocumentException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		TestBean tb = ctx.getBean(TestBean.class);
		
		ResourceLoader rl = tb.getRd();
		
		// 判断Spring是否是将自身注入到TestBean中了
		// 输出为true，表面Spring确实将自身作为参数调用了setResourceLoader方法
		System.out.println(rl == ctx);
	}
	
}
