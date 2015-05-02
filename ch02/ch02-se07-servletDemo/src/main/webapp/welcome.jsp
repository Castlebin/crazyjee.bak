<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<body>
<%
	out.print("welcome, " + session.getAttribute("name") +"!");
%>
</body>
</html>