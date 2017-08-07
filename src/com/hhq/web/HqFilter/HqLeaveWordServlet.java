package com.hhq.web.HqFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HqLeaveWordServlet",urlPatterns = "/leaveWord")
public class HqLeaveWordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String user = request.getParameter("user");
        String message = request.getParameter("message");

        System.out.println("user="+user+":"+message);

        PrintWriter out = response.getWriter();
        out.println(user+"的留言:"+message);
        out.close();

    }
}
