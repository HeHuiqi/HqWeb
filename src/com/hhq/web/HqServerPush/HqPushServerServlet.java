package com.hhq.web.HqServerPush;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HqPushServerServlet",urlPatterns = "/pushNumber",asyncSupported = true)
public class HqPushServerServlet extends HttpServlet {

    private List<AsyncContext> asyncContextList;

    @Override
    public void init() throws ServletException {


        asyncContextList = (List<AsyncContext>)getServletContext().getAttribute("async");

        System.out.println("HqPushServerServlet-List =="+asyncContextList);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AsyncContext ctx = request.startAsync();
        synchronized (asyncContextList){
            asyncContextList.add(ctx);
        }

    }
}
