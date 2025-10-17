package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX PM持仓限制信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PmPositionLimitationInfo {
    
    /** 产品类型 */
    private String instType;
    
    /** 标的指数 */
    private String uly;
    
    /** 产品ID */
    private String instFamily;
    
    /** 最大买入持仓限制 */
    private String maxBuy;
    
    /** 最大卖出持仓限制 */
    private String maxSell;
}