<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>员工首页</title>
</head>
<body>
<%@include file="../header.jsp"%> 
<%@include file="empheader.jsp"%> 
<table width="960" align="center" 
	 background="${pageContext.request.contextPath}/images/bodybg.jpg">
  <tr height="60">
	<td>&nbsp;</td>
  </tr>
  <tr>
	<td>
<s:if test="actionMessages.size()>0">
<div class="error">
	<s:actionmessage/>
</div>
</s:if>
	</td>
  </tr>
  <tr height="80">
	<td>&nbsp;</td>
  </tr>
  <tr>
	<td><s:property value="#session.user"/>
	，欢迎您使用JavaEE简单工作流系统，您是普通员工</td>
  </tr>
  <tr height="60">
	<td>&nbsp;</td>
  </tr>
</table>
<%@include file="../footer.jsp"%> 
</body>
</html>
