<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<title>Java Bean测试</title>
<body>

测试userBean、setProperty、getPropert三个JSP动作指令<br>

<%-- 创建一个Person实例，生存范围为page，名字为p1 --%>
<jsp:useBean id="p1" class="ch02.se05.directive.Person" scope="page" />
<%-- 为p1的name属性赋值 --%>
<jsp:setProperty property="name" value="crazyit.org" name="p1"/>
<%-- 为p1的age属性赋值 --%>
<jsp:setProperty property="age" value="18" name="p1"/>

<%-- 输出 --%>
<jsp:getProperty property="name" name="p1"/>
<jsp:getProperty property="age" name="p1"/>

</body>
</html>
