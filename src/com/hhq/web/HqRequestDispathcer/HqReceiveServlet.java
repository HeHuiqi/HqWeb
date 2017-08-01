package com.hhq.web.HqRequestDispathcer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HqReceiveServlet",urlPatterns = "/receive")
public class HqReceiveServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("接收请求。。。");
        //指定请求路径获取dispathcher（/deal）以在请求包含或转发过程中传递参数如 /deal?name=小明
        RequestDispatcher dispatcher = request.getRequestDispatcher("/deal?name=小明");
        //也可通过设置请求范围属性来传递值,属性的设置在请求响应结束后就自动销毁掉了
        List<String> bookNames = new ArrayList<String>();
        bookNames.add("生活指南");
        bookNames.add("娱乐指南");
        bookNames.add("工作指南");
        request.setAttribute("bookNames",bookNames);
//        dispatcher.include(request,response);
        dispatcher.forward(request,response);
        out.println("处理完成");
        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}