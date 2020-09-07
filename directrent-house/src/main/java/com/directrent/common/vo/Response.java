package com.directrent.common.vo;

import com.directrent.common.exception.ExceptionDefin;

import java.util.Collections;
import java.util.Map;

/**
 * @description: 返回对象统一封装
 * @author: YX
 * @date: 2020/09/03 21:50
 */
public class Response<T> {
    public static int SUCCESS_CODE = 200;

    public static int SYSTEM_ERROR = 500;

    private static final Map emptyMap = Collections.emptyMap();

    private int code;
    private T data;
    private String msg;

    private Response(){}

    private Response(T data) {
        this.data = data;
        this.code = SUCCESS_CODE;
    }

    private Response(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    public static Response success(){
        return Response.success(emptyMap);
    }

    public static<T> Response<T> success(T data){
        if (data == null){
            return new Response(emptyMap);
        }
        return new Response<>(data);
    }

    public static<T> Response failed(int code, String msg, T data){
        if (data == null){
            return new Response(code,emptyMap,msg);
        }
        return new Response<>(code, data, msg);
    }
    public static Response failed(int code, String msg){
        return Response.failed(code, msg, null);
    }
    public static Response failed(ExceptionDefin exceptionDefin){
        return Response.failed(exceptionDefin.getCode(), exceptionDefin.getMsg(), null);
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
