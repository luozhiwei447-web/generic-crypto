package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号机器人订单详情信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SignalBotOrderDetailsInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 客户自定义订单ID
     */
    private String algoClOrdId;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 信号源ID
     */
    private String signalSourceId;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 产品类型
     */
    private String instType;
    
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
     * 订单状态
     */
    private String state;
    
    /**
     * 总收益
     */
    private String totalPnl;
    
    /**
     * 总收益率
     */
    private String pnlRatio;
    
    /**
     * 创建时间
     */
    private String cTime;
    
    /**
     * 更新时间
     */
    private String uTime;
    
    /**
     * 订单标签
     */
    private String tag;
}