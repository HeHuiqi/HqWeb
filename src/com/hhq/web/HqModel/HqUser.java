package com.hhq.web.HqModel;

import java.io.Serializable;
//javaBean元件的必须条件
/*
1.实现Serializable接口
2.没有public的类变量
3.具有无参构造函数
4.具有公开的setter和getter方法
*/

public class HqUser implements Serializable{
    private String name;
    private String password;
    public HqUser(){}
    public void  setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkUser(){
        return "hehuiqi".equals(name)&&"123456".equals(password);
    }
}
