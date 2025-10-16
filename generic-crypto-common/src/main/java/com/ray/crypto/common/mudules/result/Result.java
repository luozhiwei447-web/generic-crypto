package com.ray.crypto.common.mudules.result;

import com.ray.crypto.common.constants.ResultCode;
import lombok.Data;

/**
 * 返回数据
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/10/17
 */
@Data
public class Result<T> {

    private String message;

    private int code;

    private T data;

    public static Result<Void> ok(){
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static Result<Void> fail(ResultCode resultCode){
        Result<Void> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }

    public static Result<Void> fail(ResultCode resultCode,String message){
        Result<Void> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMessage(message);
        return result;
    }

    public static Result<Void> systemError(){
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.SYSTEM_ERROR.getCode());
        result.setMessage(ResultCode.SYSTEM_ERROR.getMessage());
        return result;
    }

    public static Result<Void> systemError(String message){
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.SYSTEM_ERROR.getCode());
        result.setMessage(message);
        return result;
    }
}
