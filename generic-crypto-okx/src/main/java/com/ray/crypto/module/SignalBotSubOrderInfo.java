package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号机器人子订单信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SignalBotSubOrderInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 分组ID
     */
    private String groupId;
    
    /**
     * 订单ID
     */
    private String ordId;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 产品类型
     */
    private String instType;
    
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
     * 成交数量
     */
    private String accFillSz;
    
    /**
     * 成交金额
     */
    private String fillNotionalUsd;
    
    /**
     * 订单状态
     */
    private String state;
    
    /**
     * 子订单类型
     */
    private String subType;
    
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
    
    /**
     * 收益
     */
    private String pnl;
    
    /**
     * 手续费
     */
    private String fee;
    
    /**
     * 手续费币种
     */
    private String feeCcy;
    
    /**
     * 返佣
     */
    private String rebate;
    
    /**
     * 返佣币种
     */
    private String rebateCcy;
}