package ch09.se03;

import java.lang.reflect.Proxy;

public class MyProxyFactory {

	public static Object getProxy(Object target) {
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setTarget(target);
		
		// 创建并返回一个动态代理
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
	
}
