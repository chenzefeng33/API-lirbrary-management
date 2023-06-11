package com.example.library.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class R {

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    //把构造方法私有
    private R() {}

    public static R res(ResultEnum resultEnum) {
        R r = new R();
        r.setCode(resultEnum.getCode());
        r.setMessage(resultEnum.getMsg());
        return r;
    }

    public static R res(Integer code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }

    //成功静态方法
    public static R ok() {
        return res(ResultEnum.SUCCESS);
    }


    //失败静态方法
    public static R error() {
        return res(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    public static R error(Integer code, String msg) {
        return res(code, msg);
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}

