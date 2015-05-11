<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录页面</title>
</head>
<body>
http://localhost:8080/ch08-se07-spring-manage-action/loginForm
<h3>用户登录</h3>
<s:form action="login">
	<s:textfield name="username" label="用户名"/>
	<s:textfield name="password" label="密码"/>
	<tr align="center">
		<td colspan="2">
		<s:submit value="登录" theme="simple"/>
		<s:reset value="重设" theme="simple"/>
		</td>
	</tr>
</s:form>
</body>
</html>
