package com.hhq.web.HqFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "HqEncodingFilter",
        urlPatterns = "/*",
        initParams = {
        @WebInitParam(name = "ENCODING",value = "utf-8")})
public class HqEncodingFilter implements Filter{

    private  String ENCODING;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ENCODING = filterConfig.getInitParameter("ENCODING");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        if ("GET".equals(req.getMethod())){
            req = new HqEncodingServletWrapper(req,ENCODING);
        }else {

            req.setCharacterEncoding(ENCODING);
        }

        filterChain.doFilter(req,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
