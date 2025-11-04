package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SignalInfo {
    /**
     * 信号源ID
     */
    private String signalSourceId;
    
    /**
     * 信号源名称
     */
    private String signalSourceName;
    
    /**
     * 信号源类型
     */
    private String signalSourceType;
    
    /**
     * 信号ID
     */
    private String signalId;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 信号方向
     */
    private String signalSide;
    
    /**
     * 信号价格
     */
    private String signalPx;
    
    /**
     * 止盈价格
     */
    private String tpPx;
    
    /**
     * 止损价格
     */
    private String slPx;
    
    /**
     * 信号状态
     */
    private String signalState;
    
    /**
     * 信号创建时间
     */
    private String signalCTime;
    
    /**
     * 信号更新时间
     */
    private String signalUTime;
    
    /**
     * 信号描述
     */
    private String signalDesc;
}