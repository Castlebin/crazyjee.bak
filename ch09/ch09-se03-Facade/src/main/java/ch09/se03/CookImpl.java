package ch09.se03;

public class CookImpl implements Cook {
	// 实现模拟烹调食物的方法
	public String cook(String food) {
		System.out.println("厨师正在烹调:" + food);
		return food;
	}
}
