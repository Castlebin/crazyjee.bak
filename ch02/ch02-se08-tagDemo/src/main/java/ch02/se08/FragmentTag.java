package ch02.se08;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

// 定义一个带标签体的标签
public class FragmentTag extends SimpleTagSupport {
	private JspFragment fragment;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<div stype='padding:10px; border: 1px solid black; border-radius:20px'>");
		out.print("<h3>下面是动态传入的JSP片段");
		// 调用、输出“页面片段”
		fragment.invoke(null);
		out.print("</div>");
	}

	public JspFragment getFragment() {
		return fragment;
	}

	public void setFragment(JspFragment fragment) {
		this.fragment = fragment;
	}
	
	
}
