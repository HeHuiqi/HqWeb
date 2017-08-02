package com.hhq.web.HqServeltConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//在web.xml中的配置将会覆盖此标注信息注意name要一直才会覆盖
@WebServlet(name = "HqFindNameServlet",
        urlPatterns = "/findName",
        initParams = {
            @WebInitParam(name = "FIND_NAME_SUCCESS",value = "查找成功"),
            @WebInitParam(name = "FIND_NAME_FAIL",value = "查找失败")
        }
)
public class HqFindNameServlet extends HttpServlet {

    private String FIND_SUCCESS;
    private String FIND_FAIL;

    //重写init方法来获取ServletConfig的初始化信息
    @Override
    public void init(){
        FIND_SUCCESS = getInitParameter("FIND_NAME_SUCCESS");
        FIND_FAIL = getInitParameter("FIND_NAME_FAIL");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("user");
        PrintWriter out = response.getWriter();
        if ("tom".equals(name)){
            out.println(name+FIND_SUCCESS);
        }else {
            out.println(name+FIND_FAIL);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}