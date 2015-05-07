<%@page import="org.dom4j.io.SAXReader, org.dom4j.*"%>
<%@page import="java.util.*" %>
<%@page import="org.springframework.web.context.support.ServletContextResource"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<%
	   ServletContextResource sr = new ServletContextResource(application, "WEB-INF/book.xml");
		// 获取该资源的简单信息
	    out.println(sr.getFilename()+"<br>");
	    out.println(sr.getDescription()+"<br>");
	    
	    // 创建基于SAX的Dom4j解析器
	    SAXReader reader = new SAXReader();
	    Document doc = reader.read(sr.getFile());
	    // 获取根元素
	    Element el = doc.getRootElement();
	    List l = el.elements();
	    // 遍历根元素的全部子元素
	    for(Iterator it = l.iterator(); it.hasNext(); ) {
	        // 每个节点都是<书>节点
	        Element book = (Element)it.next();
	        List ll = book.elements();
	        // 遍历<书>节点的全部子节点
	        for(Iterator it2 = ll.iterator(); it2.hasNext(); ) {
	            Element eee = (Element)it2.next();
	            out.println(eee.getText()+"<br>");
	        }
	    }
	%>
</body>
</html>
