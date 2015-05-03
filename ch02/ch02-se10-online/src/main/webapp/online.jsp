<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*,ch02.se10.*" %>
<!DOCTYPE html>
<html>
<head>
	<title> 用户在线信息 </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
在线用户：
<table width="640" border="1">
<%
DbDao dd = new DbDao("com.mysql.jdbc.Driver"
	, "jdbc:mysql://localhost:3306/crazyjee"
	, "root"
	, "123456");
// 查询online_inf表（在线用户表）的全部记录
ResultSet rs = dd.query("select * from online_inf" , false);
while (rs.next())
{%>
<tr>
	<td><%=rs.getString(1)%>
	<td><%=rs.getString(2)%>
	<td><%=rs.getString(3)%>
	<td><%=rs.getString(4)%>
</tr>
<%}%>
</body>
</html>