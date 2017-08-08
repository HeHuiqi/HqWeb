<%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 2017/8/7
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查找手机</title>
</head>
<body>
<%--
相当于ifelse
--%>
<c:choose>
    <c:when test="${param.name =='iPhone' }">
        <h1>${param.name}:一个具有很多功能的手机！</h1>
    </c:when>
    <c:otherwise>
        <h1>${param.name}:查找失败</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
