package com.example.ready.retrofitpractice;

/**
 * Created by ready on 2017/10/28.
 */

//定义 接收服务器收到请求后返回的数据的类
public class Translation {
    private int status;

    private content content;
    private static class content{
        private String formal;
        private String type;
        private String vender;
        private String output;
        private int isErro;
    }
    public void show(){
        System.out.println(content.formal);
        System.out.println(content.type);
        System.out.println(content.vender);
        System.out.println(content.output);
        System.out.println(content.isErro);
    }
}
