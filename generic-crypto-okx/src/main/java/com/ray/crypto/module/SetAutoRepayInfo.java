package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置自动还币响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetAutoRepayInfo {
    
    /** 
     * 自动还币开关
     * true：开启自动还币
     * false：关闭自动还币
     */
    private String autoRepay;
}