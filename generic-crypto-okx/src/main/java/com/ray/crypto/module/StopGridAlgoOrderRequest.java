package com.ray.crypto.module;

import lombok.Data;

/**
 * 停止网格策略委托订单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class StopGridAlgoOrderRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 停止类型
     */
    private String stopType;
}