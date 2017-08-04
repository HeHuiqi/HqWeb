package com.hhq.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "HqUploadServlet")
//
@MultipartConfig
public class HqUploadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            //取得文件名子 Part 3.0才有
            Part part = request.getPart("photo");
            String filename = getFilename(part);
            writeTo(filename,part);

            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.println("上传成功");
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    class  Position{
        int begin;
        int end;

        Position(){};
        Position(int begin,int end){
            this.begin = begin;
            this.end = end;
        }
    }

    private byte[] readBody(HttpServletRequest request) throws  Exception{


        int formDataLength = request.getContentLength();
        DataInputStream dataInputStream =  new DataInputStream(request.getInputStream());
        byte[] body = new  byte[formDataLength];

        int totalByte = 0;
        while (totalByte<formDataLength){

            int readByte = dataInputStream.read(body,totalByte,formDataLength);
            totalByte += readByte;
        }

        return  body;

    }

    private  String getFilename(Part part){

        String header =  part.getHeader("Content-Disposition");
        header = header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));

        return header;
    }

    private  void  writeTo(String filename, Part part) throws  Exception{


        System.out.println("filename="+filename);
        String usrHome = System.getProperty("user.home");

        System.out.println("userHome="+usrHome);
        String dir = usrHome+"/Desktop/"+filename;
        InputStream inputStream = part.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(dir);
        byte[] buffer = new byte[1024];
        int read = 0;
        while ((read = inputStream.read(buffer))>0){
            outputStream.write(buffer,0,read);
        }
        inputStream.close();
        outputStream.close();

    }
}