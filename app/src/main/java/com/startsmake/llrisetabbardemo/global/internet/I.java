package com.startsmake.llrisetabbardemo.global.internet;

/**
 * 全局接口参数
 */

public class I {

    public static final String BASE_URL = "http://im.zxb01.com/api/";

    //获取验证码
    public static final String GET_CODE = "send/sendMsm";
    //用户注册
    public static final String USER_REGISTER = BASE_URL + "login/register";
    //用户登录
    public static final String USER_LOGIN = BASE_URL + "login/login";

}