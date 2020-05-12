package com.common.vo;

public enum ResultCode {

    SUCCESS(true,10000,"操作成功"),
    FAIL(false,10001,"操作失败");

    boolean success;
    int code;
    String message;

    private ResultCode(boolean success,int code,String message){
        this.success = success;
        this.code=code;
        this.message = message;
    }

    public boolean success(){
        return  success;
    }

    public int code(){
        return code;
    }

    public String message(){
        return message;
    }



}
