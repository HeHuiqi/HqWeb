package com.hhq.web.SimpleModleTwo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HqHelloControllerServlet",urlPatterns = "/hello")
public class HqHelloControllerServlet extends HttpServlet {

    private  HelloModel model = new HelloModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if (type == null){
            type = "hehe";
        }
        String msg = model.syaHello(type);
        request.setAttribute("message",msg);
        request.getRequestDispatcher("helloView").forward(request,response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}