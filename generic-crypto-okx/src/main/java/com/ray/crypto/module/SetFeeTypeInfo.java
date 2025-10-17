package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置手续费抵扣类型响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetFeeTypeInfo {
    
    /** 
     * 手续费抵扣类型
     * 0：USDT抵扣
     * 1：OKB抵扣
     * 2：币种抵扣
     */
    private String feeType;
}