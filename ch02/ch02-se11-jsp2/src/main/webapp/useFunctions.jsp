<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="crazyit" uri="http://castlebin.com/java/taglig/crazyit" %>
<!DOCTYPE html>
<html>
<body>
	<h2>表达式语言 - 自定义函数</h2><hr/>
	请输入一个字符串：
	<form action="useFunctions.jsp" method="post">
		字符串 = <input type="text" name="name" value="${param['name']}">
		<input type="submit"  value="提交">
	</form>
	<table border="1" bgcolor="aaaadd">
		<tr>
		<td><b>表达式语言</b></td>
		<td><b>计算结果</b></td>
		<tr>
		<tr>
			<td>\${param["name"]}</td>
			<td>${param["name"]}&nbsp;</td>
		</tr>
		<!--  使用reverse函数-->
		<tr>
			<td>\${crazyit:reverse(param["name"])}</td>
			<td>${crazyit:reverse(param["name"])}&nbsp;</td>
		</tr>
		<tr>
			<td>\${crazyit:reverse(crazyit:reverse(param["name"]))}</td>
			<td>${crazyit:reverse(crazyit:reverse(param["name"]))}&nbsp;</td>
		</tr>
		<!-- 使用countChar函数 -->
		<tr>
			<td>\${crazyit:countChar(param["name"])}</td>
			<td>${crazyit:countChar(param["name"])}&nbsp;</td>
		</tr>
	</table>
</body>
</html>