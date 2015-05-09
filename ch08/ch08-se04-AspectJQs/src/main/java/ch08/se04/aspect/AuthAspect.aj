package ch08.se04.aspect;

public aspect AuthAspect {
	
	// 指定执行ch08.se04.service包下任意类的任意方法之前先执行下面的代码块
	// 第一个星号表示返回值不限，第二个星号表示类名不限，第三个星号表示方法名不限
	// 括号中的..表示任意个数，类型不限的形参
	before() : execution(* ch08.se04.service.*.*(..) ) {
		System.out.println("模拟进行权限检查…");
	}
	
}
