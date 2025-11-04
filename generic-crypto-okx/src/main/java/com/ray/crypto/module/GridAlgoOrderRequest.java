package com.ray.crypto.module;

import lombok.Data;

/**
 * 网格策略委托下单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GridAlgoOrderRequest {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 网格上限价格
     */
    private String maxPx;
    
    /**
     * 网格下限价格
     */
    private String minPx;
    
    /**
     * 网格数量
     */
    private String gridNum;
    
    /**
     * 网格类型
     */
    private String runType;
    
    /**
     * 止盈触发价
     */
    private String tpTriggerPx;
    
    /**
     * 止损触发价
     */
    private String slTriggerPx;
    
    /**
     * 订单标签
     */
    private String tag;
    
    /**
     * 投资数量
     */
    private String quoteSz;
    
    /**
     * 投资数量（基础货币）
     */
    private String baseSz;
    
    /**
     * 单网格买入数量
     */
    private String sz;
    
    /**
     * 网格方向
     */
    private String direction;
    
    /**
     * 杠杆倍数
     */
    private String lever;
    
    /**
     * 基础货币投资数量
     */
    private String basePos;
}