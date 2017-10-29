package com.example.ready.retrofitpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ready on 2017/10/28.
 */

public class PostRequestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request();
    }
    public void request(){
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析(记得加入依赖)
                .build();
        // 步骤5:创建 网络请求接口 的实例
        PostRequest request = retrofit.create(PostRequest.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<PostTranslation> call = request.getCall("I love you");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<PostTranslation>() {
            @Override
            public void onResponse(Call<PostTranslation> call, Response<PostTranslation> response) {
                // 请求处理,输出结果
                // 输出翻译的内容
                System.out.println("翻译是" +  response.body().getTranslationResult().get(0).get(0).getResult());
            }

            @Override
            public void onFailure(Call<PostTranslation> call, Throwable t) {
                System.out.println("请求失败");
                System.out.println(t.getMessage());
            }
        });
    }
}
