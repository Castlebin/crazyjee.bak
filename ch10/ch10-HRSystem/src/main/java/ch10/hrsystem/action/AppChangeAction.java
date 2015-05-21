package ch10.hrsystem.action;

import java.util.List;

import ch10.hrsystem.action.base.EmpBaseAction;

public class AppChangeAction extends EmpBaseAction {
	private static final long serialVersionUID = -6471278885141201992L;
	// 封装所有异动的列表
	private List types;

	// types的setter和getter方法
	public void setTypes(List types) {
		this.types = types;
	}

	public List getTypes() {
		return this.types;
	}

	// 处理用户请求
	public String execute() throws Exception {
		setTypes(mgr.getAllType());
		return SUCCESS;
	}
}