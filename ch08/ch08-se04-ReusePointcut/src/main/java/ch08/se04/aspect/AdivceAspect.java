package ch08.se04.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

// 使用@Aspect定义一个切面类
//定义一个切面
@Aspect
public class AdivceAspect {
	
	// 定义AfterReturning增强处理
	@AfterReturning(pointcut = "SystemAspect.myPointcut()", returning = "rvt")
	public void log(JoinPoint jp, Object rvt) {
		System.out.println("AfterReturning增强：获取目标方法返回值:" + rvt);
		System.out.println("AfterReturning增强：模拟记录日志功能...");
		// 返回被织入增强处理的目标方法
		System.out.println("AfterReturning增强：被织入增强处理的目标方法为："
				+ jp.getSignature().getName());
		// 访问执行目标方法的参数
		System.out.println("AfterReturning增强：目标方法的参数为："
				+ Arrays.toString(jp.getArgs()));
		// 访问被增强处理的目标对象
		System.out.println("AfterReturning增强：被织入增强处理的目标对象为：" + jp.getTarget());
	}

}