package com.zmc.controller;

import com.zmc.domain.ResultStatus;
import com.zmc.exception.HeroesException;
import com.zmc.domain.Result;
import com.zmc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhongmc on 2017/4/5.
 */
@ControllerAdvice
public class ExceptionController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        if (e instanceof HeroesException){
            HeroesException heroesException = (HeroesException) e;
            return ResultUtil.error(heroesException.getCode(),heroesException.getMessage());
        }else {
            return ResultUtil.error(ResultStatus.UNKNOW_ERROR.getCode(),ResultStatus.UNKNOW_ERROR.getMsg());
        }
    }
}
