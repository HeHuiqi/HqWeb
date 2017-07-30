package com.hhq.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//在servlet3.0中使用注解的方式告诉web容器当访问到/hq.view的时候就调用HqServlet实例，这样无需在web.xml配置servlet了
@WebServlet( name = "HqServlet",urlPatterns = "/hq.view")
public class HqServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>主页</title>");
        out.println("</head>");
        out.println("<body bgcolor='green'>");
        out.println("<H1>现在是时间是："+ new Date()+"</H1>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
