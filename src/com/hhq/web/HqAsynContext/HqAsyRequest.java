package com.hhq.web.HqAsynContext;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

public class HqAsyRequest implements  Runnable{
    private AsyncContext context;
    public HqAsyRequest(AsyncContext context){
        this.context = context;
    }
    @Override
    public void run() {

        try {

            PrintWriter out = context.getResponse().getWriter();

            out.println("下载中。。。。。。");

            //模拟处理很长时间
            Thread.sleep(10000);

            out.println("<h1>下载完成了</h1>");
            //完成客户端的响应
            context.complete();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
