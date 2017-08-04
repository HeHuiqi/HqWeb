package com.hhq.web.HqFilter;

import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//继承HttpServletRequestWrapper包装类来重写getParameter方法替换html标签为实体字符

public class HqEscapeServletWrapper extends HttpServletRequestWrapper {

    public HqEscapeServletWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {

        String  value = getRequest().getParameter(name);
//        StringEscapeUtils 工具类下载
// http://www.java2s.com/Code/Java/Apache-Common/StringEscapeUtils.htm
        return StringEscapeUtils.escapeHtml(value);
    }
}
