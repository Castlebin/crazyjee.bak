<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>全部图书</title>
</head>
<body>
<h3>全部图书</h3>
<table width="640" border="1">
    <s:iterator value="books" var="book">
        <tr>
            <td><s:property value="name" /></td>
            <td><s:property value="price" /></td>
            <td><s:property value="author" /></td>
            <td><a href="${pageContext.request.contextPath}/deleteBook?id=${book.id}">删除</a></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
