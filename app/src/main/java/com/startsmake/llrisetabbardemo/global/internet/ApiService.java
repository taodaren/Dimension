package com.startsmake.llrisetabbardemo.global.internet;

import com.startsmake.llrisetabbardemo.global.bean.RegisterCodeBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/11.
 */

public interface ApiService {
    /**
     * 获取验证码
     */
    @GET("send/sendMsm")
    Observable<RegisterCodeBean> getData(
            @Query("mobile") String phoneNum);
}
