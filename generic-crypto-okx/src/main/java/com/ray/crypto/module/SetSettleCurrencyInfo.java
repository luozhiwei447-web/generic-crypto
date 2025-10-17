package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置结算币种响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetSettleCurrencyInfo {
    
    /** 产品ID */
    private String instFamily;
    
    /** 结算币种 */
    private String settleCcy;
}