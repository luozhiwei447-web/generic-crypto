package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置手续费抵扣类型请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetFeeTypeRequest {
    
    /** 
     * 手续费抵扣类型
     * 0：USDT抵扣
     * 1：OKB抵扣
     * 2：币种抵扣
     */
    private String feeType;
}