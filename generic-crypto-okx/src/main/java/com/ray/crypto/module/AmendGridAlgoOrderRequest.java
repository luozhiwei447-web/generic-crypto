package com.ray.crypto.module;

import lombok.Data;

/**
 * 修改网格策略委托订单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AmendGridAlgoOrderRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 止盈触发价
     */
    private String tpTriggerPx;
    
    /**
     * 止损触发价
     */
    private String slTriggerPx;
}