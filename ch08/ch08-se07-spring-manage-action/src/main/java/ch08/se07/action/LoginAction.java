package ch08.se07.action;

import ch08.se07.service.MyService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -7148744972555512985L;
	
	// 下面是用于封装用户请求参数的两个成员变量
	private String username;
	private String password;
	// 系统所用的业务逻辑组件
	private MyService ms;

	// 设值注入业务逻辑组件所必需的setter方法
	public void setMs(MyService ms) {
		this.ms = ms;
	}

	// username的setter和getter方法
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	// password的setter和getter方法
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	// 处理用户请求的execute方法
	public String execute() throws Exception {
		// 调用业务逻辑组件的validLogin()方法
		// 验证用户输入的用户名和密码是否正确
		if (ms.validLogin(getUsername(), getPassword()) > 0) {
			addActionMessage("哈哈，整合成功！");
			return SUCCESS;
		}
		return ERROR;
	}
}
