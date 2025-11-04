package com.ray.crypto.module;

import lombok.Data;

/**
 * 调整保证金余额请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AdjustMarginBalanceRequest {
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
    
    /**
     * 是否允许借币
     */
    private String percent;
}