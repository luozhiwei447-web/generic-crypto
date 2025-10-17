package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX最大可用余额信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MaxAvailSizeInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 最大可买可用余额 */
    private String availBuy;
    
    /** 最大可卖可用余额 */
    private String availSell;
}