<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
   <title>员工查看自己的工资</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="empheader.jsp"%>
<table width="960" align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
<tr>
<td>
<br>
<table width="80%" border="0" align="center"
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="5" ><div class="mytitle">当前用户：<s:property value="#session.user"/></div></td> 
  </tr>
  <tr class="pt11" height="45">
	<td><b>发薪月份</b></td>
	<td><b>薪水</b></td>
  </tr>
<s:iterator value="salarys" status="index">  
 	<s:if test="#index.odd == true"> 
		 <tr style="background-color:#dddddd" class="pt11" height="32">
	</s:if> 
	<s:else> 
		 <tr class="pt11" height="32">
	</s:else>
	<td><s:property value="payMonth"/></td>
	<td><s:property value="amount"/></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>