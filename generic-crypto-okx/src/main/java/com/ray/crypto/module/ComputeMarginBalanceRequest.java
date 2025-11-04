package com.ray.crypto.module;

import lombok.Data;

/**
 * 计算保证金余额请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ComputeMarginBalanceRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 调整保证金类型
     */
    private String type;
    
    /**
     * 调整保证金数量
     */
    private String amt;
}