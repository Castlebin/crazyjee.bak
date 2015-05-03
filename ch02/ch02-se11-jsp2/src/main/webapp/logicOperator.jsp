<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title> 表达式语言 - 逻辑运算符 </title>
</head>
<body>
	<h2>表达式语言 - 逻辑运算符</h2><hr/>
	数字之间的比较：
	<table border="1" bgcolor="#aaaadd">
		<tr>
			<td><b>表达式语言</b></td>
			<td><b>计算结果</b></td>
		</tr>
		<!-- 直接比较两个数字 -->
		<tr>
			<td>\${1 &lt; 2}</td>
			<td>${1 < 2}</td>
		</tr>
		<!-- 使用lt比较运算符 -->
		<tr>
			<td>\${1 lt 2}</td>
			<td>${1 lt 2}</td>
		</tr>
		<!-- 使用>比较运算符 -->
		<tr>
			<td>\${1 &gt; (4/2)}</td>
			<td>${1 > (4/2)}</td>
		</tr>
		<!-- 使用gt比较运算符 -->
		<tr>
			<td>\${1 gt (4/2)}</td>
			<td>${1 gt (4/2)}</td>
		</tr>
		<!-- 使用>=比较运算符 -->
		<tr>
			<td>\${4.0 &gt= 3}</td>
			<td>${4.0 >= 3}</td>
		</tr>
		<!-- 使用ge比较运算符 -->
		<tr>
			<td>\${4.0 ge 3}</td>
			<td>${4.0 ge 3}</td>
		</tr>
		<!-- 使用<=比较运算符 -->
		<tr>
			<td>\${4 &lt;= 3}</td>
			<td>${4 <= 3}</td>
		</tr>
		<!-- 使用le比较运算符 -->
		<tr>
			<td>\${4 le 3}</td>
			<td>${4 le 3}</td>
		</tr>
		<!-- 使用==比较运算符 -->
		<tr>
			<td>\${100.0 == 100}</td>
			<td>${100.0 == 100}</td>
		</tr>
		<!-- 使用eq比较运算符 -->
		<tr>
			<td>\${100.0 eq 100}</td>
			<td>${100.0 eq 100}</td>
		</tr>
		<!-- 使用!=比较运算符 -->
		<tr>
			<td>\${(10*10) != 100}</td>
			<td>${(10*10) != 100}</td>
		</tr>
		<!--  先执行运算，再进行比较运算，使用ne比较运算符-->
		<tr>
			<td>\${(10*10) ne 100}</td>
			<td>${(10*10) ne 100}</td>
		</tr>
	</table>
	字符之间的比较：
	<table border="1" bgcolor="#aaaadd">
		<tr>
			<td><b>表达式语言</b></td>
			<td><b>计算结果</b></td>
		</tr>
		<tr>
			<td>\${'a' &lt; 'b'}</td>
			<td>${'a' < 'b'}</td>
		</tr>
		<tr>
			<td>\${'hip' &gt; 'hit'}</td>
			<td>${'hip' > 'hit'}</td>
		</tr>
		<tr>
			<td>\${'4' &gt; 3}</td>
			<td>${'4' > 3}</td>
		</tr>
	</table>
</body>
</html>