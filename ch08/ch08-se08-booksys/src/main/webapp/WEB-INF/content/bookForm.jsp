<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加图书</title>
</head>
<body>
<h3>添加图书</h3>
<s:form action="addBook">
    <s:textfield name="book.name" label="书名" />
    <s:textfield name="book.price" label="价格" />
    <s:textfield name="book.author" label="作者" />
    <tr align="center">
        <td colspan="2">
	        <s:submit value="添加" theme="simple" />
	        <s:reset value="重置" theme="simple" />
        </td>
    </tr>
</s:form>
</body>
</html>
