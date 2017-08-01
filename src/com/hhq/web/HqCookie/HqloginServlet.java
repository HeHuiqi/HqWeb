package com.hhq.web.HqCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HqloginServlet", urlPatterns = "/hqlogin")
public class HqloginServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("hhq".equals(username)&&"123456".equals(password)){

            String auto = request.getParameter("autologin");


            if ("auto".equals(auto)){

                Cookie cookie = new Cookie("username","hhq");
                System.out.println("添加cookie="+cookie.getName()+","+cookie.getValue());
                cookie.setMaxAge(60);
                response.addCookie(cookie);
            }
            PrintWriter out = response.getWriter();

            out.println("登录成功！欢迎"+username +"!");
            out.close();
            return;
        }

        //否则重新登录
        response.sendRedirect("/hqlogin.html");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}