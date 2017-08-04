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

            System.out.println("处理中。。。。。。");
            //模拟处理很长时间
            Thread.sleep(10000);

            PrintWriter out = context.getResponse().getWriter();
            out.println("<h1>下载完成了</h1>");
            //完成客户端的响应
            context.complete();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
