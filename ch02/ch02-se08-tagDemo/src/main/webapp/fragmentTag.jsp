<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="mytag" uri="http://castlebin.com/java/taglig/mytaglib" %>
<!DOCTYPE html>
<body>
	<mytag:fragment>
		<jsp:attribute name="fragment">
			<mytag:helloworld/>
		</jsp:attribute>
	</mytag:fragment>
	<mytag:fragment>
		<jsp:attribute name="fragment">
			${pageContext.request.remoteAddr}
		</jsp:attribute>
	</mytag:fragment>
</body>
</html>