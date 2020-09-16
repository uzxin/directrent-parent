package com.directrent.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @description: layui返回对象统一封装
 * @author: YX
 * @date: 2020/09/03 21:50
 */
@Data
public class LayuiResult {
    /**
     * 返回码
     **/
    private int code = 0;
    /**
     * 返回说明
     **/
    private String msg = "操作成功";
    /**
     * 条数
     **/
    private long count = 0;
    /**
     * 返回数据
     **/
    private Object data;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date time = new Date();


    public LayuiResult() {
    }

    public LayuiResult(Object data) {
        this(0, "操作成功", data);
    }

    public LayuiResult(int code, String msg) {
        this(code, msg, null);
    }

    public LayuiResult(int code, String msg, Object data) {
        this(code, msg, 0, data);
    }

    public LayuiResult(int code, String msg, long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static LayuiResult error() {
        return new LayuiResult(1, "操作失败", null);
    }

    public static LayuiResult error(int code, String msg) {
        return new LayuiResult(code, msg, null);
    }

    public static LayuiResult error(String msg) {
        return error(1, msg);
    }


    public static LayuiResult ok() {
        return new LayuiResult(null);
    }

    public static LayuiResult ok(Object data) {
        return new LayuiResult(data);
    }

    public static LayuiResult ok(String msg) {
        return new LayuiResult(0, msg);
    }

    public static LayuiResult ok(String msg, Object data) {
        return new LayuiResult(0, msg, data);
    }

    public static LayuiResult ok(int count, Object data) {
        return new LayuiResult(0, "操作成功", count, data);
    }

}
