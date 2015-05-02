<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="mytag" uri="http://castlebin.com/java/taglig/mytaglib" %>
<!DOCTYPE html>
<body>
<%
	List<String> aList = new ArrayList<>();
	aList.add("疯狂Java讲义");
	aList.add("crazyjee");
	aList.add("crazyit.org");
	
	pageContext.setAttribute("a", aList);
%>
<table border="1" bgcolor="#aaaadd" width="300">
	<mytag:iterator item="item" collection="a">
		<tr>
			<td>${pageScope.item}</td>
		</tr>
	</mytag:iterator>
</table>
</body>
</html>