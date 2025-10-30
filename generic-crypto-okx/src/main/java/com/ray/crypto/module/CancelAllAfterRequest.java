package com.ray.crypto.module;

import lombok.Data;

/**
 * 倒计时全部撤单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelAllAfterRequest {
    /**
     * 倒计时时间，单位为秒
     */
    private String timeOut;
}