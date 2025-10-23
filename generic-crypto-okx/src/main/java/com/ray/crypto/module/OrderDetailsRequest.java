package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取订单信息请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OrderDetailsRequest {
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
}