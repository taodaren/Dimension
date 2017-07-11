package com.startsmake.llrisetabbardemo.global.util;

import com.startsmake.llrisetabbardemo.global.bean.RegisterCodeBean;
import com.startsmake.llrisetabbardemo.global.internet.ApiService;
import com.startsmake.llrisetabbardemo.global.internet.I;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HttpMethods {
    private static final int TIME_OUT = 4;
    private volatile static HttpMethods instance;

    private Retrofit retrofit;
    private ApiService apiService;

    private HttpMethods() {

        /**
         * 构造函数私有化
         * 并在构造函数中进行retrofit的初始化
         */
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().connectTimeout(TIME_OUT, TimeUnit.SECONDS);

        /**
         * 由于retrofit底层的实现是通过okhttp实现的，所以可以通过okHttp来设置一些连接参数
         * 如超时等
         */
        retrofit = new Retrofit.Builder()
                .baseUrl(I.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

    }

    public static HttpMethods getInstance() {
        if (instance == null) {
            synchronized (HttpMethods.class) {
                if (instance == null) {
                    instance = new HttpMethods();
                }
            }
        }
        return instance;
    }

    public void getRegisterCode(Observer<RegisterCodeBean> observer, String phoneNum) {

        apiService.getData(phoneNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
