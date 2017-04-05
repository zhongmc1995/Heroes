package com.zmc.domain;

/**
 * Created by zhongmc on 2017/4/5.
 * 结果集封装
 */
public class Result<T> {
    private Integer number;
    private Integer code;
    private String msg;
    private T data;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
