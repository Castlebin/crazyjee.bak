package ch02.se08;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DynaAttributesTag extends SimpleTagSupport implements DynamicAttributes {
	// 保存每个属性、值为一个Map结构
	private Map<String, Object> map = new HashMap<>();
	
	@Override
	public void doTag() throws JspException, IOException {
		// 简单的输出各个属性
		JspWriter out = getJspContext().getOut();
		for(String key : map.keySet()) {
			out.print(key + ": " + map.get(key)+"<br>");
		}
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		map.put(localName, value);
	}
	
}
