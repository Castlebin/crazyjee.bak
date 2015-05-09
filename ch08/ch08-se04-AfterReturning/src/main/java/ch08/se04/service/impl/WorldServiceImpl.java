package ch08.se04.service.impl;

import org.springframework.stereotype.Service;

import ch08.se04.service.WorldService;

@Service("worldService")
public class WorldServiceImpl implements WorldService {

	@Override
	public void bar() {
		System.out.println("执行WorldService组件中的bar()方法");
	}

}
