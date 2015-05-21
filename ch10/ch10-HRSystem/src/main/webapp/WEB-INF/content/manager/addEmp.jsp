<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>增加新员工</title>
<s:head/>
</head>
<body>
<%@include file="../header.jsp"%> 
<%@include file="mgrheader.jsp"%> 
<table width="960" align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
<tr>
<td>
请您输入新员工的资料：<br>
<s:if test="actionMessages.size()>0">
<div class="error">
	<s:actionmessage/>
</div>
</s:if>
<div align="center">
<s:form action="processAdd">
	<s:textfield name="emp.name" label="员工用户名"/>
	<s:textfield name="emp.pass" label="员工密码"/>
	<s:textfield name="emp.salary" label="员工月薪"/>
	<s:token/>
	<tr><td colspan="2">
	<s:submit value="添加新员工" theme="simple"/>
	<s:reset  theme="simple" value="重新输入"/>
	</td></tr>
</s:form>
</div>
</td>
</tr>
</table>
<%@include file="../footer.jsp"%> 
</body>
</html>
