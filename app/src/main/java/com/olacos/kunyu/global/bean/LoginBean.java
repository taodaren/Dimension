package com.olacos.kunyu.global.bean;

/**
 * Created by Administrator on 2017/7/13.
 */

public class LoginBean {

    /**
     * code : 0
     * msg : 登录成功
     * token : 71d3bc86380e0e3dfd8c72b8fef3db576440
     * uid : 30
     */

    private int code;
    private String msg;
    private String token;
    private int uid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                ", uid=" + uid +
                '}';
    }
}
