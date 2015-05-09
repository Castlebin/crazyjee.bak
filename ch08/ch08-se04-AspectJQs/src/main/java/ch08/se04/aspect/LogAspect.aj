package ch08.se04.aspect;

public aspect LogAspect {
	
	// 定义一个Pointcut，其名称为logPointcut
	// 该Pointcut代表了后面给出的切入点表达式，这样可复用该切入点表达式
	pointcut logPointcut() : execution(* ch08.se04.service.*.*(..));
	
	after() : logPointcut() {
		System.out.println("模拟日志记录…");
	}
}
