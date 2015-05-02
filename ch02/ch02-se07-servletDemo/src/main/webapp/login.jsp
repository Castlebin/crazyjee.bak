<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<body>
<%--输出出错提示 --%>
<span style="color:red;font-weight: bold">
<%
if(request.getAttribute("err") != null) {
	out.print(request.getAttribute("err") + "<br>");
}
%>
</span>
<form id="login" method="post" action="login">
	用户名：<input type="text" name="username"><br>
	密码：<input type="password" name="password"><br>
	<input type="submit" value="提交">
	<input type="reset" value="取消">
</form>
</body>
</html>