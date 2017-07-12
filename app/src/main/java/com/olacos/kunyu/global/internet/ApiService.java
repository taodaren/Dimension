package com.olacos.kunyu.global.internet;

import com.olacos.kunyu.global.bean.LoginBean;
import com.olacos.kunyu.global.bean.RegisterCodeBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
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

    /**
     * 登录
     */
    @POST(I.USER_LOGIN)
    Observable<LoginBean> getData(
            @Query("username") String phoneNum, @Query("password") String pwd
    );
}
