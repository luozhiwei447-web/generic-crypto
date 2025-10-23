package com.ray.crypto.module;

import lombok.Data;

/**
 * 订单详情信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OrderDetailsInfo {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 订单ID
     */
    private String ordId;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 订单标签
     */
    private String tag;
    
    /**
     * 委托价格
     */
    private String px;
    
    /**
     * 委托数量
     */
    private String sz;
    
    /**
     * 订单类型
     */
    private String ordType;
    
    /**
     * 订单方向
     */
    private String side;
    
    /**
     * 持仓方向
     */
    private String posSide;
    
    /**
     * 交易模式
     */
    private String tdMode;
    
    /**
     * 累计成交数量
     */
    private String accFillSz;
    
    /**
     * 平均成交价格
     */
    private String avgPx;
    
    /**
     * 订单状态
     */
    private String state;
    
    /**
     * 订单创建时间
     */
    private String cTime;
    
    /**
     * 订单更新时间
     */
    private String uTime;
}