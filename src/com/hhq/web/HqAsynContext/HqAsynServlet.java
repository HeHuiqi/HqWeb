package com.hhq.web.HqAsynContext;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(name = "HqAsynServlet", urlPatterns = "/download",asyncSupported = true)

public class HqAsynServlet extends HttpServlet {

    //创建一个线程池
   private ExecutorService executorService = Executors.newFixedThreadPool(10);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        AsyncContext context = request.startAsync();

        //提交线程执行
        executorService.submit(new  HqAsyRequest(context));

    }

    @Override
    public void destroy() {
        executorService.shutdown();

    }
}
