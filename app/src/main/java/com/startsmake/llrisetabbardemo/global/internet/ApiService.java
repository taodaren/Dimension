package com.startsmake.llrisetabbardemo.global.internet;

import com.startsmake.llrisetabbardemo.global.bean.RegisterCodeBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/7/11.
 */

public interface ApiService {
    /**
     * 获取验证码
     */
    @GET(I.GET_CODE)
    Observable<RegisterCodeBean> getData();
}
