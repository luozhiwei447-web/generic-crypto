package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号机器人平仓请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CloseSignalBotPositionRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 产品ID
     */
    private String instId;
}