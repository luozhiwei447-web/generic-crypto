package com.ray.crypto.common.exception;

import com.ray.crypto.common.constants.ResultCode;
import lombok.Getter;

/**
 * 异常
 */
@Getter
public class GenericException extends Exception {

    private final ResultCode code;

    public GenericException(ResultCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public GenericException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    public GenericException(String message) {
        super(message);
        this.code = ResultCode.SYSTEM_ERROR;
    }
}
