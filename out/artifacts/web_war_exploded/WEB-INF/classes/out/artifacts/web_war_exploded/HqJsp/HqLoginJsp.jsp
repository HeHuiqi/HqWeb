<%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 2017/8/7
  Time: 上午8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="16kb" errorPage="HqError.jsp" %>

<%--

1.<%@ %>指示元素，用声明文件的编码、语言，还有import、include，声明文件的需要的类或文件

2.<%! %> 声明元素可以声明成员变量或方法

2.<% %>脚本元素不能声明方法，但可以调用方法，声明变量（局部变量）相当于在一个方法或块的内部操作
实际上<% %>中的代码会被转译成servlet中__jspService()方法中的内容

3.<%= %>表达式元素，获取变量的值或计算表达式
表达式的结果会直接转为jsp隐式对象out的println（表达式）输出到页面

--%>
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

    //发生异常或错误时才会跳转到错误页面
//    int a = 6/0;

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
