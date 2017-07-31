package com.hhq.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //设置跨域访问
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");

        PrintWriter out = response.getWriter();

        String loginResult = "登录成功！欢迎您 "+username+"! -----";
        out.println(loginResult);
        /*
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()){

            String name = names.nextElement();
            out.println( name+":"+request.getHeader(name)+"  ");
        }*/

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
       PrintWriter out = response.getWriter();
       out.println("请使用post请求");
       out.close();

    }
}
