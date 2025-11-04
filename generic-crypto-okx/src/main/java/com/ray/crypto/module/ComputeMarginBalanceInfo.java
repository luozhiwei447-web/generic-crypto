package com.ray.crypto.module;

import lombok.Data;

/**
 * 计算保证金余额响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ComputeMarginBalanceInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 杠杆倍数
     */
    private String lever;
    
    /**
     * 最大可用余额
     */
    private String maxAmt;
}