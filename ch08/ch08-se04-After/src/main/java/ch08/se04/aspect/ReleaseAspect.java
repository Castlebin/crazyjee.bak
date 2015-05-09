package ch08.se04.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

// 使用@Aspect定义一个切面类
@Aspect
public class ReleaseAspect {

	// 匹配ch08.se04.service.impl包下所有类的所有方法的执行作为切入点
	@After("execution(* ch08.se04.service.impl.*.*(..))")
	public void release() {
		System.out.println("模拟方法结束后的资源释放操作…");
	}
	
}
