package com.startsmake.llrisetabbardemo.global.internet;

import com.startsmake.llrisetabbardemo.global.bean.RegisterCodeBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 请求服务接口
 */

public interface ApiService {
    /**
     * 获取验证码
     */
    @GET(I.GET_CODE)
    Observable<RegisterCodeBean> getData(
            @Query("mobile") String phoneNum
    );
}
