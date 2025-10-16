package com.ray.crypto.core.exception;


import com.ray.crypto.common.constants.ResultCode;
import com.ray.crypto.common.exception.GenericException;
import com.ray.crypto.common.mudules.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/10/17
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public Result<Void> genericExceptionHandler(GenericException exception){
        return Result.fail(exception.getCode(),exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<Void> exceptionHandler(Exception exception){
        return Result.fail(ResultCode.SYSTEM_ERROR,exception.getMessage());
    }
}
