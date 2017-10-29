package com.example.ready.retrofitpractice;

import java.util.List;

/**
 * Created by ready on 2017/10/29.
 */
//服务器返回数据的接收类
public class PostTranslation {
    private String type;
    private int errorCode;
    private int elapsedTime;
    private List<List<TranslationResultBean>> TranslationResult;

    public String getType(){ return type;}
    public void setType(String type){this.type = type;}
    public int getErrorCode(){return errorCode;}
    public void setErrorCode(int error){this.errorCode = error;}
    public int getElapsedTime(){return elapsedTime;}
    public void setElapsedTime(int time){this.elapsedTime = time;}
    public List<List<TranslationResultBean>> getTranslationResult(){return TranslationResult;}
    public void setTranslationResult(List<List<TranslationResultBean>> translation){
        this.TranslationResult = translation;
    }

    public static class TranslationResultBean{
        public String source;
        public String result;

        public String getSource(){return source;}
        public void setSource(String src){ this.source = src;}
        public String getResult(){return result;}
        public void setResult(String res){this.result = result;}
    }
}
