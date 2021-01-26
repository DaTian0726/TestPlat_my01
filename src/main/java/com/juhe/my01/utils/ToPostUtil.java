package com.juhe.my01.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ToPostUtil {
    /**
     *
     * @param url
     * @param req
     * @return  请求结果
     */
    public static JSONObject doPostOkHttp(String url, String req) {
        //拿到OkHttpClient对象
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        //构建Body，传入参数
        RequestBody body = RequestBody.create(MediaType.parse("application/text; charset=utf-8"), req);
        //构建Request，将FormBody作为POST方法的参数传入
//        System.out.println(req);
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        //将Request封装为Call
        Call call = client.newCall(request);
        //调用请求，重写回调方法
        try {
            Response response = null;
            response = call.execute();
            JSONObject resp = new JSONObject();
            resp.put("body",response.body().string());
            resp.put("headers",response.headers().toString());
            resp.put("response",response.toString());
            return resp;
        } catch (IOException e) {
            System.out.println("请求错误"+e);
        }
        return null;
    }

    public static JSONObject ToGet(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        //构建一个请求对象
        Request request = new Request.Builder().url(url).build();
        //发送请求
        try {
            Response response = okHttpClient.newCall(request).execute();
            //打印服务端传回的数据
            JSONObject resp = new JSONObject();
            resp.put("body",response.body().string());
            resp.put("headers",response.headers().toString());
            resp.put("response",response.toString());
            return resp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





}
