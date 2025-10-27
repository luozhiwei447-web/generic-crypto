package com.ray.crypto.module;

import lombok.Data;

/**
 * 改单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AmendOrderRequest {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 订单ID
     */
    private String ordId;
    
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
     * 新的委托价格
     */
    private String newPx;
}