package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号机器人事件历史信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SignalBotEventHistoryInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 事件ID
     */
    private String eventId;
    
    /**
     * 事件类型
     */
    private String eventType;
    
    /**
     * 事件描述
     */
    private String eventDesc;
    
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
     * 执行状态
     */
    private String execStatus;
    
    /**
     * 执行结果
     */
    private String execResult;
    
    /**
     * 事件时间
     */
    private String eventTime;
    
    /**
     * 创建时间
     */
    private String cTime;
}