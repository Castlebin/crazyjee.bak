package ch10.hrsystem.action.authority;

import ch10.hrsystem.action.WebConstant;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MgrAuthorityInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 4402836304321753088L;

	public String intercept(ActionInvocation invocation) throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的level属性
		String level = (String) ctx.getSession().get(WebConstant.LEVEL);
		// 如果level不为null，且level为mgr
		if (level != null && level.equals(WebConstant.MGR_LEVEL)) {
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
}