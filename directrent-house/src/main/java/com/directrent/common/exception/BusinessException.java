package com.directrent.common.exception;

/**
 * @description:
 * @author: YX
 * @date: 2020/9/1 22:31
 */
public class BusinessException extends BaseException {

    private ExceptionDefin exceptionDefine;

    public BusinessException(ExceptionDefin exceptionDefine){
        super(exceptionDefine.getCode(), exceptionDefine.getMsg());
        this.exceptionDefine = exceptionDefine;
    }

    public BusinessException(int code, String msg) {
        super(code, msg);
    }

    public ExceptionDefin getExceptionDefine() {
        return exceptionDefine;
    }
}