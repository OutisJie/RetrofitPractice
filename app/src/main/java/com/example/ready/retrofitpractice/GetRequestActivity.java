package com.example.ready.retrofitpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ready on 2017/10/29.
 */

public class GetRequestActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            request();
        }
        public void request() {
            //创建retrofit对象
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                    .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                    .build();

            //创建网络请求接口的实例
            GetRequest request = retrofit.create(GetRequest.class);

            //对发送请求进行封装
            Call<Translation> call = request.getCall();

            //发送网络请求（异步）
            call.enqueue(new Callback<Translation>() {
                @Override
                public void onResponse(Call<Translation> call, Response<Translation> response) {
                    //处理返回数据的结果
                    response.body().show();
                }

                @Override
                public void onFailure(Call<Translation> call, Throwable t) {
                    System.out.println("链接失败");
                }
            });
        }
}
