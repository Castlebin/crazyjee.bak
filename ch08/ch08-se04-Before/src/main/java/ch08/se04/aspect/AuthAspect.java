package ch08.se04.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 使用@Aspect定义一个切面类
@Aspect
public class AuthAspect {

	// 匹配ch08.se04.service.impl包下所有类的所有方法的执行作为切入点
	@Before("execution(* ch08.se04.service.impl.*.*(..))")
	public void authority() {
		System.out.println("模拟执行权限检查…");
	}
	
}
