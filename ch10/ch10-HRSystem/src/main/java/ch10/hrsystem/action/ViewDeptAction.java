package ch10.hrsystem.action;

import java.util.List;

import ch10.hrsystem.action.base.MgrBaseAction;
import ch10.hrsystem.vo.SalaryBean;

import com.opensymphony.xwork2.ActionContext;

public class ViewDeptAction extends MgrBaseAction {
	private static final long serialVersionUID = 4011937035417564040L;
	// 封装发薪列表的List成员变量
	private List sals;

	// sals的setter和getter方法
	public void setSals(List sals) {
		this.sals = sals;
	}

	public List getSals() {
		return this.sals;
	}

	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// 调用业务逻辑方法取得当前员工的全部发薪列表
		List<SalaryBean> result = mgr.getSalaryByMgr(mgrName);
		setSals(result);
		return SUCCESS;
	}
}