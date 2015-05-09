package ch08.se04.aspect;

public aspect TxAspect {
	
	// 指定执行任意方法时替换为执行下面的方法
	Object around() : call(* ch08.se04.service.*.*(..)) {
		System.out.println("模拟开启事务…");
		
		// 回调原来的目标方法
		Object rvt = proceed();
		
		System.out.println("模拟事务结束…");
		
		return rvt;
	}
	
}
