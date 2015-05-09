package ch08.se04.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

// 使用@Aspect定义一个切面类
@Aspect
public class LogAspect {

	// 匹配ch08.se04.service.impl包下所有类的所有方法的执行作为切入点
	@AfterReturning(returning="rvt", 
			pointcut="execution(* ch08.se04.service.impl.*.*(..))")
	public void log(Object rvt) {
		System.out.println("获取目标方法的返回值为：" + rvt);
		System.out.println("模拟执行日志记录…");
	}
	
}
