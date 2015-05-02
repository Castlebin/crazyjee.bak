<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<table bgcolor="#9999dd" border="1" width="300px">
<%
	for(int i=0; i<10; i++) {
%>
	<tr>
		<td>循环值：</td>
		<td><%= i %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>
