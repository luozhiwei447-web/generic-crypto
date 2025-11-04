package com.ray.crypto.module;

import lombok.Data;

/**
 * 创建信号机器人请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CreateSignalBotRequest {
    /**
     * 信号源ID
     */
    private String signalSourceId;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 投资数量
     */
    private String investmentAmt;
    
    /**
     * 投资币种
     */
    private String investmentCcy;
    
    /**
     * 杠杆倍数
     */
    private String lever;
    
    /**
     * 止盈比例
     */
    private String tpRatio;
    
    /**
     * 止损比例
     */
    private String slRatio;
    
    /**
     * 订单标签
     */
    private String tag;
}