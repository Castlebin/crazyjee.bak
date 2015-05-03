<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<head>
	<title> 登录页面 </title>
</head>
<body>
<h2>登录页面</h2>
<%
session.setAttribute("user" 
	, request.getParameter("name"));
%>
登录成功，可以访问该应用的其他页面
</body>
</html>