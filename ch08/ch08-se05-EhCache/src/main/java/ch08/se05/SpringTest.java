package ch08.se05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.se05.domain.User;
import ch08.se05.service.UserService;

public class SpringTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		UserService userService = ctx.getBean(UserService.class);
		
		// 第一次执行，直接结果会缓存下来
		User u1 = userService.getUserByNameAndAge("heller", 18);
		
		// 第二次执行，可以看到程序直接利用了缓存区的数据，并没有直接执行方法
		User u2 = userService.getUserByNameAndAge("heller", 18);
		
		// 另一个方法，但是参数相同
		User u3 = userService.getAnotherUser("heller", 18);
		
		// u1 == u2 == u3 充分显示了Spring对类进行@Cacheable注解的效果
		System.out.println(u1 == u2);// true
		System.out.println(u1 == u3);// true
		
		ctx.close();
	}
	
}
