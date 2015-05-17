package ch09.se03;

public class WaiterImpl implements Waiter {
	// 模拟服务生上菜的方法
	public void serve(String food) {
		System.out.println("服务生已将" + food + "端过来了，请慢用...");
	}
}
