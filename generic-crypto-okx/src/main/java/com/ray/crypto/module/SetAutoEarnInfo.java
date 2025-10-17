package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置自动赚币响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetAutoEarnInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 是否开启自动赚币 */
    private String autoEarn;
}