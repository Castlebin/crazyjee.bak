<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%-- 下面是JSP声明部分 --%>
<%!
	// 声明一个变量
	public int count;
	
	// 声明一个方法
	public String info() {
		return "hello";
	}
%>
<body>
<%
	out.print(count++);
%>
<%
	out.print(info());
%>
</body>
</html>
