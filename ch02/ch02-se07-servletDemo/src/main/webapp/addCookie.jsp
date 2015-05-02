<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<%
	String name = request.getParameter("name");
	Cookie c = new Cookie("username", name);
	// 设置Cookie对象的生存时间
	c.setMaxAge(60);// 60s
	// 向客户端增加cookie
	response.addCookie(c);
%>

</body>
</html>
