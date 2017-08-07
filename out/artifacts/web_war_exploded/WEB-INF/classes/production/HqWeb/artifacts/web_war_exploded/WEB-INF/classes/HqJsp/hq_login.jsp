<%--
  Created by IntelliJ IDEA.
  User: hehuiqi
  Date: 8/6/17
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    //声明元素
    String name = "hhq";
    String password = "123456";
    public  boolean checkUser(String user,String password){

        return this.name.equals(user)&&this.password.equals(password);
    }
%>
<html>
<head>
    <title>登录结果</title>
</head>
<body>
<%
    String user = request.getParameter("user");
    String password = request.getParameter("password");
    if (checkUser(user,password)){
%>
<h1>登录成功</h1>
<%}else {%>
<h1>登录失败</h1>
<%}%>
</body>
</html>
