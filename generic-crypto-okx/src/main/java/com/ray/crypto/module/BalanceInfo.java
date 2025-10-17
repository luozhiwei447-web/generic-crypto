package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX账户余额信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class BalanceInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 余额 */
    private String bal;
    
    /** 冻结余额 */
    private String frozenBal;
    
    /** 可用余额 */
    private String availBal;
}