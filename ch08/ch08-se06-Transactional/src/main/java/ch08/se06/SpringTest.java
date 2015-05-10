package ch08.se06;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.se06.dao.NewsDao;

public class SpringTest {
	public static void main(String[] args) {
		// 创建Spring容器
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		// 获取事务代理Bean
		NewsDao dao = ctx.getBean(NewsDao.class);
		// 执行插入操作
		dao.insert("疯狂Java", "轻量级Java EE企业应用实战");
		
		ctx.close();
	}
}