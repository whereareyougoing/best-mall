package com.imooc.mall.common;

/**
 * @author 宋艾衡
 * @date 2019/6/26 21:58
 * @desc
 *
 * 这个结果类可以在统一返还类里面封装统一返回结果，把返回的状态和描述返回回去，让统一返回类更加简洁
 *
 */
public class Result {

    private Boolean status;
    private Integer code;
    private String message;


    public Result() {
    }

    public Result(Boolean status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public Result(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
