package com.zmc.exception;

import com.zmc.domain.ResultStatus;

/**
 * Created by zhongmc on 2017/4/5.
 */
public class HeroesException extends RuntimeException {
    private Integer code;
    public HeroesException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public HeroesException(ResultStatus resultStatus){
        super(resultStatus.getMsg());
        this.code = resultStatus.getCode();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
