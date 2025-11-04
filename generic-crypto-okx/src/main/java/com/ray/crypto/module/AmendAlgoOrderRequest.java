package com.ray.crypto.module;

import lombok.Data;

/**
 * 修改策略委托订单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AmendAlgoOrderRequest {
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
    
    /**
     * 客户自定义修改事件ID
     */
    private String reqId;
    
    /**
     * 新的委托数量
     */
    private String newSz;
    
    /**
     * 新的触发价格
     */
    private String newTriggerPx;
    
    /**
     * 新的委托价格
     */
    private String newOrderPx;
}