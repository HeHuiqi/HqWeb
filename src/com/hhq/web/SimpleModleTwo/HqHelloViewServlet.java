package com.hhq.web.SimpleModleTwo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HqHelloViewServlet", urlPatterns = "/helloView")
public class HqHelloViewServlet extends HttpServlet {

    private  String htmlTemplate = "<html>"
            +"<head>"
            +"<meta charset=utf-8>"
            +"<title>%s</title>"
            +"</head>"
            +"<body>"
            +"<h1>%s<h1>"
            +"</body>"
            +"</html>";
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String type = request.getParameter("type");
        if (type == null){
            type = "嗨";
        }
        String msg = (String) request.getAttribute("message");
        String html = String.format(htmlTemplate,type,msg);
        response.getWriter().println(html);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}