package ch10.hrsystem.action;

import ch10.hrsystem.action.base.EmpBaseAction;
import ch10.hrsystem.domain.Manager;
import ch10.hrsystem.service.EmpManager;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends EmpBaseAction {
	private static final long serialVersionUID = 4571143181503244037L;

	// 定义一个常量作为员工身份登录成功的Result
	private final String EMP_RESULT = "emp";

	// 定义一个常量作为经理身份登录成功的Result
	private final String MGR_RESULT = "mgr";

	// 定义一个成员变量用于封装请求参数
	private Manager manager;

	// 登录时的验证码
	private String vercode;

	// manager的setter和getter方法
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Manager getManager() {
		return this.manager;
	}

	// vercode的setter和getter方法
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	public String getVercode() {
		return this.vercode;
	}

	// 处理用户请求的方法
	@Override
	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的rand属性值
		String ver2 = (String)ctx.getSession().get("rand");
		if(vercode.equalsIgnoreCase(ver2)) {// 验证码输入无误
			// 调用业务逻辑方法来处理用户请求
			int result = mgr.validLogin(getManager());
			// 登录结果为员工
			if(result == EmpManager.LOGIN_EMP) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				
				addActionMessage("您已成功登录系统！");
				return EMP_RESULT;
			} else if(result == EmpManager.LOGIN_MGR) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.MGR_LEVEL);
				addActionMessage("您已成功登录系统！");
				return MGR_RESULT;
			} else {// 用户名密码验证不通过
				addActionMessage("对不起，您未能通过用户名、密码验证！");
			}
		} else {// 验证码不通过
			addActionMessage("对不起，您的验证码输入有误！");
		}
		
		return ERROR;
	}
}
