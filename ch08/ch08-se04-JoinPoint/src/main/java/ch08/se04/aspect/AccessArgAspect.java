package ch08.se04.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

// 使用@Aspect定义一个切面类
//定义一个切面
@Aspect
public class AccessArgAspect {
	// 定义AfterReturning增强处理
	@AfterReturning(pointcut = "execution(* ch08.se04.service.impl.*.*(..)) && args(arg0, arg1)", returning = "rvt")
	// 此处arg形参都限制了类型，所以目标方法中参数也被限定了
	public void access(Object rvt, String arg0, String arg1) {
		System.out.println("使用args来直接访问参数…");
		System.out.println("arg0: " + arg0);
		System.out.println("arg1: " + arg1);
		System.out.println("目标方法的返回值为：" + rvt);
	}
}