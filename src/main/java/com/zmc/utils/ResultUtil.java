package com.zmc.utils;

import com.zmc.domain.Result;

/**
 * Created by zhongmc on 2017/4/5.
 */
public class ResultUtil {
    public static Result success(Object o,Integer number){
        Result result = new Result();
        result.setCode(100);
        result.setNumber(number);
        result.setMsg("success");
        result.setData(o);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setNumber(0);
        result.setData(null);
        return result;
    }
}
