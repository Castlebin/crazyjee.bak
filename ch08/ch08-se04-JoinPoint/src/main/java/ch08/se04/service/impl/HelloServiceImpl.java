package ch08.se04.service.impl;

import org.springframework.stereotype.Service;

import ch08.se04.service.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public void foo() {
		System.out.println("执行HelloService组件中的foo()方法");
	}

	@Override
	public String addUser(String name, String pass) {
		System.out.println("执行HelloService组件中的addUser()方法，添加用户：" + name);
				
		return name;
	}

}
