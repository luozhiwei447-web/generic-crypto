package com.ray.crypto.module;

import lombok.Data;

/**
 * 网格策略委托订单持仓信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GridAlgoOrderPositionInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 产品类型
     */
    private String instType;
    
    /**
     * 持仓方向
     */
    private String posSide;
    
    /**
     * 持仓数量
     */
    private String pos;
    
    /**
     * 可平仓数量
     */
    private String availPos;
    
    /**
     * 平均开仓价格
     */
    private String avgPx;
    
    /**
     * 未实现收益
     */
    private String upl;
    
    /**
     * 未实现收益率
     */
    private String uplRatio;
    
    /**
     * 保证金
     */
    private String margin;
    
    /**
     * 杠杆倍数
     */
    private String lever;
    
    /**
     * 标记价格
     */
    private String markPx;
    
    /**
     * 创建时间
     */
    private String cTime;
    
    /**
     * 更新时间
     */
    private String uTime;
}