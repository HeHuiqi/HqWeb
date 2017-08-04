package com.hhq.web.HqFilter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//应用于所有的请求
@WebFilter(filterName = "HqEscapeFilter",urlPatterns = "/*")
public class HqEscapeFilter implements  Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request = new HqEscapeServletWrapper(request);

        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
