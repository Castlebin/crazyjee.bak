<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="mytag" uri="http://castlebin.com/java/taglig/mytaglib"%>
<!DOCTYPE html>
<body>
	<mytag:query user="root" url="jdbc:mysql://localhost/crazyjee"
		pass="123456" driver="com.mysql.jdbc.Driver"
		sql="select * from news_inf" />
</body>
</html>