package com.directrent.common.exception;

/**
 * @description:
 * @author: YX
 * @date: 2020/9/1 22:30
 */
public class BaseException extends RuntimeException {

    private int code;
    private String msg;

    public BaseException(int code, String msg){
        super("ErrorCode:" + code + ",ErrorMsg:" + msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(ExceptionDefine exceptionDefine){
        super("ErrorCode:" + exceptionDefine.getCode() + ",ErrorMsg:" + exceptionDefine.getMsg());
        this.code = exceptionDefine.getCode();
        this.msg = exceptionDefine.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}