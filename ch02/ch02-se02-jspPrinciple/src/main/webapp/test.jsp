<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"  %>
<!DOCTYPE html>
<html>
<body>
	<!-- 下面是Java脚本 -->
	<%
		for(int i=0; i<7; i++) {
			out.print("<font size='" + i + "'>");
	%>
		疯狂Java训练营（Wild Java Camp）</font><br />
	<%
		}
	%>
</body>
</html>
