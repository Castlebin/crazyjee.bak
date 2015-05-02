<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<title>forware的原始页</title>
<body>
<h3>forware的原始页面</h3>
<jsp:forward page="forward-result.jsp">
	<jsp:param value="28" name="age"/>
</jsp:forward>
</body>
</html>
