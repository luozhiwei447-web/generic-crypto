package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号机器人调整保证金余额请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SignalBotAdjustMarginRequest {
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