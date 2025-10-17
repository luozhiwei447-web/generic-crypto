package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX最大可买卖/开仓数量信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MaxSizeInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 保证金币种 */
    private String ccy;
    
    /** 最大可买数量 */
    private String maxBuy;
    
    /** 最大可卖数量 */
    private String maxSell;
}