package ch08.se05.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ch08.se05.domain.User;
import ch08.se05.service.UserService;

@Cacheable(value="users", unless="#age<100")// 指定了unless属性，表示在复合某些条件情况下才不使用缓存，与condition过刚好相反
@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public User getUserByNameAndAge(String name, int age) {
		System.out.println("---正在执行getUserByNameAndAge()查询方法---");
		return new User(name, age);
	}

	@Override
	public User getAnotherUser(String name, int age) {
		System.out.println("---正在执行getAnotherUser()查询方法---");
		return new User(name, age);
	}

}
