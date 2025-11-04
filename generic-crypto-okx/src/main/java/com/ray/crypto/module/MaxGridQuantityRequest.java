package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取最大网格数量请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MaxGridQuantityRequest {
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 网格上限价格
     */
    private String maxPx;
    
    /**
     * 网格下限价格
     */
    private String minPx;
}