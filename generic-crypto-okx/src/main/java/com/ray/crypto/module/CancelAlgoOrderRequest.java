package com.ray.crypto.module;

import lombok.Data;

/**
 * 撤销策略委托订单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelAlgoOrderRequest {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 策略委托订单ID
     */
    private String algoId;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
}