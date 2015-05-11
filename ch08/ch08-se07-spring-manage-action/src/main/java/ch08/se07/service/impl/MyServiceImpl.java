package ch08.se07.service.impl;

import ch08.se07.service.MyService;

public class MyServiceImpl implements MyService {
	public int validLogin(String username, String pass) {
		// 此处只是简单示范，故直接判断用户名、密码是否符合要求
		if (username.equals("heller") && pass.equals("123456")) {
			return 99;
		}
		return -1;
	}
}
