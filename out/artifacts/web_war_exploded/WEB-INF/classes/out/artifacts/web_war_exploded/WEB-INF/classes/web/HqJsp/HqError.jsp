<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 2017/8/7
  Time: 下午12:44
  To change this template use File | Settings | File Templates.

--%>
<%--
isErrorPage="true" 时才表示这是一个错误处理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误</title>
</head>
<body>
<h1>呀！页面找不到了！</h1>
<!--显示异常信息只有isErrorPage="true"的页面才可以使用exception对象-->
<h2><%=exception %></h2>
<%
    //打印异常跟踪栈信息
    exception.printStackTrace(new PrintWriter(out));
%>
</body>
</html>
