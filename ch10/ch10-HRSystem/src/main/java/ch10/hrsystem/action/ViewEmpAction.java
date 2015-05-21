package ch10.hrsystem.action;

import java.util.List;

import ch10.hrsystem.action.base.MgrBaseAction;

import com.opensymphony.xwork2.ActionContext;

public class ViewEmpAction extends MgrBaseAction {
	private static final long serialVersionUID = -3713554313684398387L;
	// 封装当前经理所有员工的List
	private List emps;

	// emps的setter和getter方法
	public void setEmps(List emps) {
		this.emps = emps;
	}

	public List getEmps() {
		return this.emps;
	}

	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		setEmps(mgr.getEmpsByMgr(mgrName));
		return SUCCESS;
	}
}