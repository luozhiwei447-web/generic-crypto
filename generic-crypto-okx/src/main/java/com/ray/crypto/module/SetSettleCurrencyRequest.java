package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置结算币种请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetSettleCurrencyRequest {
    
    /** 产品ID */
    private String instFamily;
    
    /** 结算币种 */
    private String settleCcy;
}