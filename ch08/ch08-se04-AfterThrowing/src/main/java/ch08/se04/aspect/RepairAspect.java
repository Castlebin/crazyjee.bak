package ch08.se04.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

// 使用@Aspect定义一个切面类
@Aspect
public class RepairAspect {

	// 匹配ch08.se04.service.impl包下所有类的所有方法的执行作为切入点
	// ex为抛出的异常，ex的类型可以限制目标方法必须抛出指定类型的异常
	// 此处ex类型指定未Throwable，表示不对目标方法抛出的异常类型做限制，也就是说目标方法可以抛出任意类型的异常
	@AfterThrowing(throwing="ex", 
			pointcut="execution(* ch08.se04.service.impl.*.*(..))")
	public void doRecoveryActions(Throwable ex) {
		System.out.println("目标方法中抛出的异常：" + ex);
		System.out.println("模拟Advice对异常进行的修复操作…");
	}
	
}
