package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX产品最大可借信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MaxLoanInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 
     * 保证金模式
     * isolated：逐仓
     * cross：全仓
     */
    private String mgnMode;
    
    /** 保证金币种 */
    private String mgnCcy;
    
    /** 最大可借数量 */
    private String maxLoan;
    
    /** 币种 */
    private String ccy;
    
    /** 持仓方向，仅适用于逐仓模式 */
    private String side;
}