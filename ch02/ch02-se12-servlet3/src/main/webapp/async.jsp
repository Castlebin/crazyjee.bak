<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<ul>
		<c:forEach items="${books}" var="book">
			<li>${book}</li>
		</c:forEach>
	</ul>
	<%
		out.print("业务调用结束的时间：" + new Date());
		if (request.isAsyncStarted()) {
			// 完成异步调用
			request.getAsyncContext().complete();
		}
	%>
</body>
</html>
