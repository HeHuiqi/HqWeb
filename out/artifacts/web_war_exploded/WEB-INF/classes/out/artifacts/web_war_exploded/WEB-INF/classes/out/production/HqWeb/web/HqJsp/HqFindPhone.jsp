
<%@page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 2017/8/7
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--
<%@taglib %> 引入jstl标签库可在apache官网下载到
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>查找手机</title>
</head>
<body>
<%--
相当于ifelse
这里的操作可以有多个<c:when>标签来组合多种情况的输出，没有匹配的就输出 <c:otherwise>
标签的内容
--%>
<c:choose>
    <c:when test="${param.name =='iPhone' }">
        <h1>${param.name}:一个具有很多功能的昂贵手机！</h1>
    </c:when>
    <c:when test="${param.name =='Android' }">
        <h1>${param.name}:一个具有很多功能的大众手机！</h1>
    </c:when>
    <c:otherwise>
        <h1>${param.name}:查找失败</h1>
    </c:otherwise>
</c:choose>

<%--
获取数据：

•EL表达式主要用于替换JSP页面中的脚本表达式，以从各种类型的web域 中检索java对象、获取数据。(某个web域 中的对象，访问javabean的属性、访问list集合、访问map集合、访问数组)
执行运算：

•利用EL表达式可以在JSP页面中执行一些基本的关系运算、逻辑运算和算术运算，以在JSP页面中完成一些简单的逻辑运算。${user==null}
获取web开发常用对象

•EL 表达式定义了一些隐式对象，利用这些隐式对象，web开发人员可以很轻松获得对web常用对象的引用，从而获得这些对象中的数据。
调用Java方法

•EL表达式允许用户开发自定义EL函数，以在JSP页面中通过EL表达式调用Java类的方法

1.使用EL表达式获取数据语法：“${标识符}”
2.EL表达式语句在执行时，会调用pageContext.findAttribute方法，用标识符为关键字，
分别从page、request、session、application四个域中查找相应的对象，找到则返回相应对象，
找不到则返回”” （注意，不是null，而是空字符串）。
EL表达式${xxx}会先看xxx是不是EL表达式的隐式对象，是就直接返回隐式对象的引用，
不是就翻译成pageContext.findAttribute（“xxx”）

数据的获取需要从当前页面的各种隐式对象中才能获取，自定义的变量需要成为隐式对象的属性
才能获取到正确的值或者指javaBean对象

--%>

<%
    String[] numbers = {"1","2","3","4","5","6"};
//    request.setAttribute("numbers",numbers);

%>
<table id="num" style="text-align: center;width: 30%;" border="1">
    <tr>
        <td>数字</td>
    </tr>

    <c:forEach var="num" items="${numbers}">
        <tr>
            <td>${num}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>字符串</td>
    </tr>
    <c:forEach var="str" items="java,OC,NodeJS">
        <tr>
            <td>${str}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
