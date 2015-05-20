package ch10.hrsystem.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2016, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class EmpBean implements Serializable {
	private static final long serialVersionUID = -7809616652851310956L;
	
	private String empName;
	private String empPass;
	private double amount;

	// 无参数的构造器
	public EmpBean() {
	}

	// 初始化全部成员变量的构造器
	public EmpBean(String empName, String empPass, BigDecimal bigDecimal) {
		this.empName = empName;
		this.empPass = empPass;
		this.amount = bigDecimal.doubleValue();
	}

	// empName的setter和getter方法
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return this.empName;
	}

	// empPass的setter和getter方法
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String getEmpPass() {
		return this.empPass;
	}

	// amount的setter和getter方法
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}

}