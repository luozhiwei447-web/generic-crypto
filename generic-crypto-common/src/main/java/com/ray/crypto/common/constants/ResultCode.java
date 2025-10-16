package com.ray.crypto.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回信息
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/10/17
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    SYSTEM_ERROR(500,"系统错误"),
    SUCCESS(200,"成功"),
    ;

    private final int code;
    private final String message;
}
