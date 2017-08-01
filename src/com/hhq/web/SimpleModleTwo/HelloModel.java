package com.hhq.web.SimpleModleTwo;

import java.util.HashMap;
import java.util.Map;

public class HelloModel {

    private Map<String,String> message = new HashMap<String,String>();

    public  HelloModel(){
        message.put("hehe","嗨");
        message.put("haha","哈哈");
        message.put("heihei","嘿嘿");
    }

    public  String syaHello(String type){

        String msg = message.get(type);
        msg = msg + ",你好！";
        return msg;
    }

}
