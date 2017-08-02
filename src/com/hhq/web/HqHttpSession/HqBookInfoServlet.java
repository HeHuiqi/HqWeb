package com.hhq.web.HqHttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HqBookInfoServlet", urlPatterns = "/bookInfo")
public class HqBookInfoServlet extends HttpServlet {

        /*
            out.println("<html>");
            out.println("<head>");
            out.println("<mate charset=utf-8>");
            out.println("<title></title>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession httpSession = request.getSession();
        String bookName = (String) httpSession.getAttribute("findBook");
        PrintWriter out = response.getWriter();
        System.out.println("bookName="+bookName);
        if (bookName !=null){
            out.println("<html>");
            out.println("<head>");
            out.println("<mate charset=utf-8>");
            out.println("<title>"+bookName+"</title>");
            out.println("<body>");
            out.println("<h1>"+bookName+":真是生活的好帮手"+"</h1>");
            out.println("<a href='/clearSession'> 清除"+bookName+"图书信息"+"</a>");
            out.println("</body>");
            out.println("</html>");
            System.out.println("获得Session");

        }else{
            response.sendRedirect("/HqHttpSessionUI/find_book.html");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}