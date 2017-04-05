package com.zmc.domain;

/**
 * Created by zhongmc on 2017/4/5.
 */
public enum ResultStatus {

    UNKNOW_ERROR(-1,"未知异常"),
    SUCCESS(100,"success"),
    ARGUMENT_BINDING_ERROR(200,"参数绑定错误"),
    NO_SUCH_HERO(201,"无该英雄");
    private Integer code;
    private String msg;
    private ResultStatus(Integer code,String msg){
        this.code = code;
        this.msg = msg;
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
}
