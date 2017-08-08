package com.hhq.web.HqFilter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//web.xml也配置了,注意web.xml的配置会覆盖此标注的配置
@WebFilter(filterName = "HqEscapeFilter",urlPatterns = "/*",asyncSupported = true)
public class HqEscapeFilter implements  Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        WebFilter webFilter = (WebFilter)HqEscapeFilter.class.getAnnotation(WebFilter.class);
        System.out.println("urlPatterns="+webFilter.urlPatterns()[0]);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("HqEscapeFilter-url===="+request.getRequestURI());
        request = new HqEscapeServletWrapper(request);
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
