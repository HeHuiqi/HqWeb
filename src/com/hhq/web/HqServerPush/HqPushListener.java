package com.hhq.web.HqServerPush;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class  HqPushTask implements  Runnable{
    private List<AsyncContext> asyncContextList;
    public  HqPushTask(List<AsyncContext> list){
        this.asyncContextList = list;
    }
    @Override
    public void run() {

        while (true){

            try {

                double time =  Math.random()*10000;

                double num = Math.random()*10;
                Thread.sleep((int)time);

                synchronized (asyncContextList){
                    for (AsyncContext ctx:asyncContextList){

                        System.out.println("time =="+time);
                        try {
                            ctx.getResponse().getWriter().println(num);
                            ctx.complete();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    asyncContextList.clear();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
@WebListener
public class HqPushListener implements ServletContextListener {

    private List<AsyncContext> asyncContextList = new ArrayList<AsyncContext>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        servletContextEvent.getServletContext().setAttribute("async",asyncContextList);

        asyncContextList = (List<AsyncContext>)servletContextEvent.getServletContext().getAttribute("async");

        System.out.println("asyncContextList =="+asyncContextList);

        HqPushTask task = new HqPushTask(asyncContextList);
        new Thread(task,"task").start();
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {

                        int time = (int) Math.random()*100;
                        double num = Math.random()*10;
                        Thread.sleep(time);

                        synchronized (asyncContextList){
                            for (AsyncContext ctx:asyncContextList){

                                try {
                                    ctx.getResponse().getWriter().println(num);
                                    ctx.complete();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                            asyncContextList.clear();

                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
