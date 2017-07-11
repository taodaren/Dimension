package com.startsmake.llrisetabbardemo.global.bean;

/**
 * 验证码实体类
 */

public class RegisterCodeBean {

    /**
     * code : 1
     * msg : 手机号已存在
     */

    private int code;
    private String msg;

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

    @Override
    public String toString() {
        return "RegisterCodeBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
