package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号机器人子订单下单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PlaceSignalBotSubOrderRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 订单方向
     */
    private String side;
    
    /**
     * 订单类型
     */
    private String ordType;
    
    /**
     * 委托数量
     */
    private String sz;
    
    /**
     * 委托价格
     */
    private String px;
    
    /**
     * 是否只减仓
     */
    private String reduceOnly;
}