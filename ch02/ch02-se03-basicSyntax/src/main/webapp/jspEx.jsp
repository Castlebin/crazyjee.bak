<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%-- 下面是JSP声明 --%>
<%!
	public int count;
	public String info() {
		return "hello";
	}
%>

<%-- JSP表达式 --%>
<%= count++ %>
<%= info() %>
</body>
</html>
