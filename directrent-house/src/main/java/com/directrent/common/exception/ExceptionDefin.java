package com.directrent.common.exception;

/**
 * @description: 自定义异常
 * @author: YX
 * @date: 2020/09/01 22:37
 */
public enum ExceptionDefin {

    SERVER_ERROR(500, "网络异常，请稍后重试"),
    LOGIN_ERROR(10000, "登录状态不合法"),
    PARSE_ERROR(10001, "转换失败");


    private int code;
    private String msg;

    ExceptionDefin(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}