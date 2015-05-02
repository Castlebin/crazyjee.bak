package ch02.se08;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		// 获取页面输出流，并输出字符串
		getJspContext().getOut().write("Hello World, " + new Date());
	}
	
}
