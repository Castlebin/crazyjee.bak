package ch10.hrsystem.action.base;

import ch10.hrsystem.service.EmpManager;

import com.opensymphony.xwork2.ActionSupport;

public class EmpBaseAction extends ActionSupport {
	private static final long serialVersionUID = -7052925792248794222L;

	protected EmpManager mgr;

	public void setEmpManager(EmpManager mgr) {
		this.mgr = mgr;
	}
	
}
