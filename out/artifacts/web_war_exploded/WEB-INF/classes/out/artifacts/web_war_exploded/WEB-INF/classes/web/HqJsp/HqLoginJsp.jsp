<%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 2017/8/7
  Time: 上午8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String user = "hehuiqi";
    String password = "123456";

    public boolean checkUser(String user,String password){

        return this.user.equals(user)&&this.password.equals(password);
    }
%>

<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String user = request.getParameter("user");
    String password = request.getParameter("password");
    if (checkUser(user,password)){
%>
<h1><%= user+":"%>登录成功</h1>
<%
    }else {
%>
<h1><%= user+":"%>登录失败</h1>
<%}%>
</body>
</html>
