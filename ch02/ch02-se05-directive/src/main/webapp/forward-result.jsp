<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<h3>forward的结果页</h3>
<!-- 使用jsp内置对象request来获取请求参数 -->
<%=request.getParameter("age") %>
<%=request.getParameter("username") %>
</body>
</html>
