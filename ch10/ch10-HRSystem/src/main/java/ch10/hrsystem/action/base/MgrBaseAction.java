package ch10.hrsystem.action.base;

import ch10.hrsystem.service.MgrManager;

import com.opensymphony.xwork2.ActionSupport;

public class MgrBaseAction extends ActionSupport {
	private static final long serialVersionUID = -5768310603373109441L;
	
	protected MgrManager mgr;

	public void setMgrManager(MgrManager mgr) {
		this.mgr = mgr;
	}
	

}
