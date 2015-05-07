package ch08.se03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		// classpath前缀可以用来匹配多个spring xml配置文件，它会合并配置为一个整个的ApplicationContext
		// classpath*:*-bean.xml表示匹配所有类加载路径下所有*-bean.xml形式的配置文件
		// 而默认情况（不加通配符）只加载找到的第一个复合条件的xml配置
		// t-bean.xml并不符合这个表达式，所以看到没有被加载
		ctx = new ClassPathXmlApplicationContext("classpath*:*-bean.xml");
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
	}
}
