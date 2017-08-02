package com.hhq.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "HqShowPDFServlet", urlPatterns = "/showpdf")
public class HqShowPDFServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/pdf");
        InputStream in = getServletContext().getResourceAsStream("/hqbook.pdf");
        //获取输出流
        OutputStream out = response.getOutputStream();
        try {
            writeByte(in,out);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private  void writeByte(InputStream in , OutputStream out) throws  Exception{

        byte[] buffer = new byte[1024];

        int readLength = 0;

        while ((readLength = in.read(buffer))>0){

            out.write(buffer,0,readLength);
        }

        in.close();
        out.close();


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}