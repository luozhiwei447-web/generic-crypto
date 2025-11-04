package com.ray.crypto.module;

import lombok.Data;

/**
 * 立即触发网格策略订单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class InstantTriggerGridRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
}