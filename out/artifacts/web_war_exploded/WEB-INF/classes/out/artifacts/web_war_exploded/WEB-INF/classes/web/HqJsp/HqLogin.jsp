<%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 2017/8/7
  Time: 下午2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="HqError.jsp" %>
<%--指定要使用的javaBean元件--%>
<jsp:useBean id="user" class="com.hhq.web.HqModel.HqUser" scope="page"/>
<%--设置javaBean对象属性*代表自动点用对象所有的setter方法对属性设置值
javaBean中的属性名称要与请求参数的用户名称相同才能设置成功
--%>
<jsp:setProperty name="user" property="*"></jsp:setProperty>
<html>
<head>
    <title>JavaBean的使用（登录）</title>
</head>
<body>
<%
    if (user.checkUser()){
        
%>
<!--使用el表达式来获取属性值,el表达式只能获取值不能设置值-->
<h1>${user.name="12412"}</h1>
<%
    }else {
%>
<!--使用jsp:getProperty标签来获取属性值-->
<h1><jsp:getProperty name="user" property="name"></jsp:getProperty>登录失败</h1>
<%}%>
</body>
</html>
