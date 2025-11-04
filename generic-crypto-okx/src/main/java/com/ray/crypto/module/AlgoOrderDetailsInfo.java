package com.ray.crypto.module;

import lombok.Data;

/**
 * 策略委托订单详情信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AlgoOrderDetailsInfo {
    /**
     * 产品类型
     */
    private String instType;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 策略委托订单ID
     */
    private String algoId;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 订单类型
     */
    private String ordType;
    
    /**
     * 委托数量
     */
    private String sz;
    
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
     * 触发价格
     */
    private String triggerPx;
    
    /**
     * 委托价格
     */
    private String orderPx;
    
    /**
     * 实际委托量
     */
    private String actualSz;
    
    /**
     * 实际委托价
     */
    private String actualPx;
    
    /**
     * 订单状态
     */
    private String state;
    
    /**
     * 杠杆倍数
     */
    private String lever;
    
    /**
     * 订单标签
     */
    private String tag;
    
    /**
     * 创建时间
     */
    private String cTime;
    
    /**
     * 触发时间
     */
    private String triggerTime;
    
    /**
     * 订单更新时间
     */
    private String uTime;
    
    /**
     * 止盈触发价
     */
    private String tpTriggerPx;
    
    /**
     * 止盈委托价
     */
    private String tpOrdPx;
    
    /**
     * 止损触发价
     */
    private String slTriggerPx;
    
    /**
     * 止损委托价
     */
    private String slOrdPx;
    
    /**
     * 触发价格类型
     */
    private String triggerPxType;
    
    /**
     * 止盈触发价格类型
     */
    private String tpTriggerPxType;
    
    /**
     * 止损触发价格类型
     */
    private String slTriggerPxType;
    
    /**
     * 回调比率
     */
    private String callbackRatio;
    
    /**
     * 回调价差
     */
    private String callbackSpread;
    
    /**
     * 激活价格
     */
    private String activePx;
    
    /**
     * 移动触发价
     */
    private String moveTriggerPx;
    
    /**
     * 价格比率
     */
    private String pxVar;
    
    /**
     * 价格上限
     */
    private String pxSpread;
    
    /**
     * 单笔数量
     */
    private String szLimit;
    
    /**
     * 挂单间隔
     */
    private String pxLimit;
    
    /**
     * 时间间隔
     */
    private String timeInterval;
    
    /**
     * 数量比率
     */
    private String count;
    
    /**
     * 算法订单ID
     */
    private String algoClOrdId;
    
    /**
     * 推送时间
     */
    private String pushTime;
    
    /**
     * 失败原因
     */
    private String failCode;
    
    /**
     * 关联订单数据
     */
    private String linkedAlgoOrd;
    
    /**
     * 是否只减仓
     */
    private String reduceOnly;
}