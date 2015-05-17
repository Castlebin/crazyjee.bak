package ch09.se03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	// 需要被代理的目标对象
	private Object target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		TxUtil tx = new TxUtil();
		
		tx.beginTx();
		Object result = method.invoke(target, args);
		tx.endTx();
		
		return result;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
}
