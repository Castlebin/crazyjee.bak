<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<head>
	<title>登录页面</title>
</head>
<body>
<h2>登录页面</h2>
<%
if(request.getAttribute("tip") != null)
{
	out.println("<font color='red'>" 
		+ request.getAttribute("tip")
		+ "</font>");
}
%>
<form method="post" action="proLogin.jsp">
用户名:<input type="text" name="name"/><br/>
<input type="submit" value="登录"/>
</form>
</body>
</html>