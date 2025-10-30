package com.ray.crypto.module;

import lombok.Data;

/**
 * 闪兑交易响应
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class EasyConvertInfo {
    /**
     * 卖出币种
     */
    private String fromCcy;
    
    /**
     * 买入币种
     */
    private String toCcy;
    
    /**
     * 卖出数量
     */
    private String fromSz;
    
    /**
     * 买入数量
     */
    private String toSz;
    
    /**
     * 兑换汇率
     */
    private String usdPx;
    
    /**
     * 闪兑交易ID
     */
    private String instId;
    
    /**
     * 交易时间戳
     */
    private String ts;
}