package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置自动还币请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetAutoRepayRequest {
    
    /** 
     * 自动还币开关
     * true：开启自动还币
     * false：关闭自动还币
     */
    private Boolean autoRepay;
}