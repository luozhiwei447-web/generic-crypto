package com.ray.crypto.module;

import lombok.Data;

import java.util.List;

/**
 * OKX API统一响应格式
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OkxResponse<T> {
    
    /**
     * 错误码，0表示成功
     */
    private String code;
    
    /**
     * 错误信息
     */
    private String msg;
    
    /**
     * 响应数据
     */
    private T data;
}