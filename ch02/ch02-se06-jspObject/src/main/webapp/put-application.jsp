<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%!
	int i;
%>
<%
	application.setAttribute("counter", ++i);
%>
<%= i %>
</body>
</html>
