package com.imooc.mall.common;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * @author 宋艾衡
 * @date 2019/3/29 17:51
 * @desc
 */
public class ServerResponse<T> implements Serializable {


    // 可以用这样的一个类，代替code，message，和 status
    private Result result;


    private int status;
    private String message;
    private T data;

    public ServerResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ServerResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status) {
        this.status = status;
    }


    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String message){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String message,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), message,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String message){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> ServerResponse<T> createByError(String message,T data){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), message, data);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(Integer errorCode,String message){
        return new ServerResponse<T>(errorCode, message);
    }



}
