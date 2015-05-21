package ch10.hrsystem.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import ch10.hrsystem.action.base.EmpBaseAction;

import com.opensymphony.xwork2.ActionContext;

public class PunchAction extends EmpBaseAction {
	private static final long serialVersionUID = -8647501205659004489L;

	private int punchIsValid;
	
	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String user = (String)ctx.getSession().get(WebConstant.USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dutyDay = sdf.format(new Date());
		int result = mgr.validPunch(user, dutyDay);
		setPunchIsValid(result);
		return SUCCESS;
	}

	public int getPunchIsValid() {
		return punchIsValid;
	}
	public void setPunchIsValid(int punchIsValid) {
		this.punchIsValid = punchIsValid;
	}
}
