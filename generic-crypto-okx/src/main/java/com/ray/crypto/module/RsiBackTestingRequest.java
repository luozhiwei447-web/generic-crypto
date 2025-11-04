package com.ray.crypto.module;

import lombok.Data;

/**
 * RSI策略回测请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class RsiBackTestingRequest {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 时间粒度
     */
    private String timeframe;
    
    /**
     * RSI阈值
     */
    private String threshold;
    
    /**
     * 时间周期
     */
    private String timePeriod;
    
    /**
     * 触发信号
     */
    private String triggerCond;
    
    /**
     * 持续时间
     */
    private String duration;
}