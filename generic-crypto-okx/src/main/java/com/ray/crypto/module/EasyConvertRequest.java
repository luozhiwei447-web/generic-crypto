package com.ray.crypto.module;

import lombok.Data;

/**
 * 闪兑交易请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class EasyConvertRequest {
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
}