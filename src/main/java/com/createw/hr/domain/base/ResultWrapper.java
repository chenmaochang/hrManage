package com.createw.hr.domain.base;


public class ResultWrapper<T> {
    Integer code;
    String message;
    T data;

    public ResultWrapper() {
    }
    public ResultWrapper(T data){
        this(0,"success",data);
    }

    public ResultWrapper(T data, String message){
        this(0,message,data);
    }

    public ResultWrapper(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void success( T data){
        this.data = data;
        this.code = 0;
        this.message = "success";
    }

    public void error(Integer code){
        this.code = code;
        this.message = "Error";
    }

}
