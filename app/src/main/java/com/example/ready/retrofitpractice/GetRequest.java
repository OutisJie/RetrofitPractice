package com.example.ready.retrofitpractice;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ready on 2017/10/28.
 */

//定义描述网络请求的接口
public interface GetRequest {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();
    //注解中传入部分url地址
    //retrofit把网络请求分成了两部分，一部分在网络请求的接口中，一部分在retrofit的对象里
    //如果接口中的url是一个完整的网站，那么retrofit对象中的部分可以忽略
    //getCall()是接受网络请求数据的方法
    }
