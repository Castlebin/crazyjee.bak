package ch08.se04.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 使用@Aspect定义一个切面类
//定义一个切面
@Aspect
public class SystemAspect {
	
	// 使用@Pointcut定义一个可以复用的切面
	@Pointcut("execution(* ch08.se04.service.impl.*.*(..))")
	public void myPointcut(){};
	
}