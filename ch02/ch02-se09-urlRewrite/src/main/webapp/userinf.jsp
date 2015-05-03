<%@ page contentType="text/html; charset=utf-8" %>
<%
// 获取请求参数
String user = request.getParameter("username");
%>
<!DOCTYPE html>
<html>
<head>
	<title> <%=user%>的个人信息 </title>
</head>
<body>
<%
// 此处应该通过数据库读取该用户对应的信息
// 此处只是模拟，因此简单输出：
out.println("现在时间是：" + new java.util.Date() + "<br/>");
out.println("用户名：" + user);
%>
</body>
</html>