<%@page contentType="text/html; charset=UTF-8" isErrorPage="true"%>
<%@page info="this is the error page" %>
<!DOCTYPE html>
<html>
<body>
	异常类型是：<%= exception.getClass() %>
	异常信息：<%= exception.getMessage() %>
</body>
</html>
