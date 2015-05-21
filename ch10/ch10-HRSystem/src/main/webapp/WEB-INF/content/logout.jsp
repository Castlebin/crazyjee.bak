<%
  session.invalidate();
%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
   <title>系统登出</title>
</head>
<body>
<%@include file="header.jsp"%>
<table width="960" border="0" align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
  <tr>
	<td height="264"><div align="center"><font color="#336666" size="3"><b>您已经成功地登出系统，欢迎下次光临</b></font></div></td>
  </tr>
</table>
<%@include file="footer.jsp"%>
</body>
</html>


