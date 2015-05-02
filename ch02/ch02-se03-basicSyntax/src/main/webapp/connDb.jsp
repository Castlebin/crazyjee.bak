<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<body>
<%
	// 注册数据库驱动
	Class.forName("com.mysql.jdbc.Driver");
	// 获取数据库连接
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crazyjee", "root", "123456");
	// 创建Statement
	Statement stmt = conn.createStatement();
	// 执行查询
	ResultSet rs = stmt.executeQuery("select * from news_inf");
%>
<table bgcolor="#9999dd" border="1" width="300">
<%
	// 遍历结果集
	while(rs.next()) {%>
		<tr>
			<td><%= rs.getString(1) %></td>
			<td><%= rs.getString(2) %></td>
		</tr>
<%
	}
%>
</table>
</body>
</html>
