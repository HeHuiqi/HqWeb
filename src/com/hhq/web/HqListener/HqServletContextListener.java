package com.hhq.web.HqListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//ServletContextListener监听器会在容器启动时初始化，并调用一下contextInitialized方法，在容器销毁时调用contextDestroyed
@WebListener
public class HqServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext context = servletContextEvent.getServletContext();
        String param = context.getInitParameter("CONTEXT_INIT_PARAM1");
        System.out.println("contextInitialized-param="+param);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("HqServletContextListener-contextDestroyed");

    }
}
