package com.ray.crypto.module;

import lombok.Data;

/**
 * RSI策略回测响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class RsiBackTestingInfo {
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
    
    /**
     * 年化收益率
     */
    private String annualizedRate;
    
    /**
     * 最大回撤
     */
    private String maxDrawdown;
    
    /**
     * 胜率
     */
    private String winRatio;
    
    /**
     * 夏普比率
     */
    private String sharpeRatio;
}