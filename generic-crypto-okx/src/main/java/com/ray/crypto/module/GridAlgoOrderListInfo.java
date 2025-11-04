package com.ray.crypto.module;

import lombok.Data;

/**
 * 网格策略委托订单列表信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class GridAlgoOrderListInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 客户自定义订单ID
     */
    private String algoClOrdId;
    
    /**
     * 产品类型
     */
    private String instType;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 创建时间
     */
    private String cTime;
    
    /**
     * 更新时间
     */
    private String uTime;
    
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 订单状态
     */
    private String state;
    
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
     * 投资数量
     */
    private String quoteSz;
    
    /**
     * 投资数量（基础货币）
     */
    private String baseSz;
    
    /**
     * 网格方向
     */
    private String direction;
    
    /**
     * 基础货币投资数量
     */
    private String basePos;
    
    /**
     * 单网格买入数量
     */
    private String sz;
    
    /**
     * 杠杆倍数
     */
    private String lever;
    
    /**
     * 实际杠杆倍数
     */
    private String actualLever;
    
    /**
     * 利润分享比例
     */
    private String profitSharingRatio;
    
    /**
     * 总收益
     */
    private String totalPnl;
    
    /**
     * 总收益率
     */
    private String pnlRatio;
    
    /**
     * 投资金额
     */
    private String investment;
    
    /**
     * 网格利润
     */
    private String gridProfit;
    
    /**
     * 浮动盈亏
     */
    private String floatProfit;
    
    /**
     * 已取消网格数量
     */
    private String canceledNum;
    
    /**
     * 订单标签
     */
    private String tag;
}