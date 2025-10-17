package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX账户余额请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class BalanceRequest {
    
    /** 币种，如BTC */
    private String ccy;
}