<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"  %>
<!DOCTYPE html>
<html>
<body>
	欢迎学习Java Web知识，现在时间是：
	<%
		out.print(new Date());
	%>
</body>
</html>
