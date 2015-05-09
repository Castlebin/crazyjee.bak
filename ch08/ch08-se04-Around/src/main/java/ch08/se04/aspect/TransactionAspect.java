package ch08.se04.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

// 使用@Aspect定义一个切面类
@Aspect
public class TransactionAspect {

	// 匹配ch08.se04.service.impl包下所有类的所有方法的执行作为切入点
	@Around("execution(* ch08.se04.service.impl.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("模拟在执行目标方法之前开启事务…");
		
		// 获取目标方法的原始调用参数
		Object[] args = jp.getArgs();
		if(args != null && args.length > 1) {
			// 修改目标方法调用参数的第一个参数
			args[0] = "【增加的前缀】" + args[0];
		}
		
		// 以改变之后的参数去调用目标方法
		Object rvt = jp.proceed(args);
		
		System.out.println("模拟在目标方法结束之后结束事务");
		
		return rvt;
	}
	
}
