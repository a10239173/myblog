package com.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {

    private boolean success;
    private int code;
    private String message;
    private Object data;

    public Result(ResultCode resultCode,Object data){
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
        this.data = data;
    }

    public Result(ResultCode resultCode){
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
    }

    public Result(boolean success,int code,String message,Object data){
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }



}
