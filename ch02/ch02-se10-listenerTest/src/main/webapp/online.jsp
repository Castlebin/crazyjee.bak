<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<title> 用户在线信息 </title>
</head>
<body>
在线用户：
<table width="640" border="1">
<%
Map<String, String> online = (Map<String, String>)application.getAttribute("online");
for(String sessionId : online.keySet()) {
%>
<tr>
	<td><%=sessionId%>
	<td><%=online.get(sessionId)%>
</tr>
<%}%>
</body>
</html>