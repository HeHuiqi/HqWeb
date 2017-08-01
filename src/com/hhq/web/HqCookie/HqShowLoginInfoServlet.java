package com.hhq.web.HqCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HqShowLoginInfoServlet", urlPatterns = "/hqloginInfo")
public class HqShowLoginInfoServlet extends HttpServlet {
    protected  void  showProcessRequest(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            System.out.println("存在cookie");
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("name="+name);
                System.out.println("value="+value);
                if ("username".equals(name)&&"hhq".equals(value)){

                    PrintWriter out = response.getWriter();
                    out.println("自动登录成功！欢迎"+value +"!");
                    out.close();
                    return;
                }
            }
        }
        //如果没有cookie就重写登录
        response.sendRedirect("/hqlogin.html");

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        showProcessRequest(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}