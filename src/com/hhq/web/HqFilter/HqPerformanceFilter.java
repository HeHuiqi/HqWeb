package com.hhq.web.HqFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//当HqPerformanceFilter被容器载入并实例化后
// 调用init方法并传入FilterConfig对象
//在web.xml已配置
public class HqPerformanceFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("HqPerformanceFilter-init-"+filterConfig);
        this.filterConfig = filterConfig;

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        long begin = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        filterConfig.getServletContext().log("request process in "+(System.currentTimeMillis()-begin)+" millsSecond!");

    }

    @Override
    public void destroy() {

    }
}
