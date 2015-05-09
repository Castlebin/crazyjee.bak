package ch08.se05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.se05.domain.User;
import ch08.se05.service.UserService;

public class SpringTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");

		UserService us = ctx.getBean("userService", UserService.class);
		// 第一次调用us对象的方法时会执行该方法，并缓存方法的结果
		User u1 = us.getUserByNameAndAge("孙悟空", 500);
		// 由于getAnotherUser()方法使用另一个缓存区，
		// 因此无法使用getUsersByNameAndAge()方法缓存区的数据。
		User u2 = us.getAnotherUser("孙悟空", 500);
		System.out.println(u1 == u2); // 输出false
		// getAnotherUser("孙悟空", 500)已经执行过一次，故下面代码使用缓存
		User u3 = us.getAnotherUser("孙悟空", 500);
		System.out.println(u2 == u3); // 输出true

		ctx.close();
	}

}
