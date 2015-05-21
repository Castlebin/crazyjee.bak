package ch10.hrsystem.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import ch10.hrsystem.service.EmpManager;

public class PayJob extends QuartzJobBean {
	// 判断作业是否执行的旗标
	private boolean isRunning = false;
	
	// 该作业所依赖的业务逻辑组件
	private EmpManager empMgr;

	public void setEmpMgr(EmpManager empMgr) {
		this.empMgr = empMgr;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		if(!isRunning) {
			System.out.println("系统开始调度自动结算工资…");
			isRunning = true;
			// 调用业务逻辑方法
			empMgr.autoPay();
		}
	}

}
