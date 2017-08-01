package com.hhq.web.HqRequestDispathcer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "HqDealServlet",urlPatterns = "/deal")
public class HqDealServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");

        //获得请求属性的值
        List<String> bookNames = (List<String>) request.getAttribute("bookNames");
        out.println(name+"的请求"+"正在处理中。。。。");
        out.println(name+"的书籍="+bookNames);
        out.println(request.getHeaderNames());

        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()){
            String name1 = names.nextElement();
            out.println( name1+":"+request.getHeader(name1));
        }
        //被请求派发包含的Servlet不要关闭字符流，否则后边就不在执行了
//        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}