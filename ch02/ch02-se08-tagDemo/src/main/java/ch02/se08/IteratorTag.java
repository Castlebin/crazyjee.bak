package ch02.se08;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

// 定义一个带标签体的标签
public class IteratorTag extends SimpleTagSupport {
	// 定义要迭代的集合
	private String collection;
	// 标签属性，为迭代元素命名
	private String item;
	
	@Override
	public void doTag() throws JspException, IOException {
		// 从page scope中获取名为collection的集合
		Collection<?> itemList = (Collection<?>)getJspContext().getAttribute(collection);
		// 遍历集合
		for(Object o : itemList) {
			// 将集合元素值设置到page范围内
			getJspContext().setAttribute(item, o);
			
			// 输出标签体
			getJspBody().invoke(null);
		}
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	
}
