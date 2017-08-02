package com.hhq.web.HqHttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HqFindBookServlet", urlPatterns = "/findBook")
public class HqFindBookServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String bookName = request.getParameter("book_name");
        String bookNumber = request.getParameter("book_number");

        PrintWriter out = response.getWriter();

        if ("生活指南".equals(bookName)&&"1".equals(bookNumber)){
            request.getSession().setAttribute("findBook",bookName);
           System.out.println("设置Session");
           request.getRequestDispatcher("/bookInfo").forward(request,response);
        }else {
            out.println("<html>");
            out.println("<head>");
            out.println("<mate charset=utf-8>");
            out.println("<title>"+bookName+"</title>");
            out.println("<body>");
            out.println("<h1>"+bookName+":真是一本好书！"+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}