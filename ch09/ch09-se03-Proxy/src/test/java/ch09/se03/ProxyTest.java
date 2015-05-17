package ch09.se03;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void testProxy() {
		long start = System.currentTimeMillis();
		Image image = new ImageProxy(null);
		
		System.out.println("系统得到Image对象的时间开销：" + (System.currentTimeMillis() - start));
		
		// 只有当实际调用image代理的show()方法时，才会真正的创建被代理对象
		image.show();
	}
	
}
