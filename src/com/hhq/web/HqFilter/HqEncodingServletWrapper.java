package com.hhq.web.HqFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;


public class HqEncodingServletWrapper extends HttpServletRequestWrapper{

    private  String encoding;
    public HqEncodingServletWrapper(HttpServletRequest request,String encoding) {
        super(request);
        this.encoding = encoding;
    }

    @Override
    public String getParameter(String name){

        String value = getRequest().getParameter(name);

        if (value !=null){

            try {
                byte[] bytes = value.getBytes("ISO-8859-1");
                value = new String(bytes,encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return value;
    }
}
