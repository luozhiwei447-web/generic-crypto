package com.ray.crypto.module;

import lombok.Data;

/**
 * 修改信号机器人止盈止损请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AmendSignalBotTpSlRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 止盈比例
     */
    private String tpRatio;
    
    /**
     * 止损比例
     */
    private String slRatio;
}