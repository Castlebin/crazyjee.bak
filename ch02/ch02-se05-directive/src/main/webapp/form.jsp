<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<!-- 表单提交页面 -->
<form id="login-form" action="jsp-forward.jsp" method="post">
	<input type="text" name="username">
	<input type="submit" value="login">
</form>
<%=request.getParameter("gender") %>
</body>
</html>
