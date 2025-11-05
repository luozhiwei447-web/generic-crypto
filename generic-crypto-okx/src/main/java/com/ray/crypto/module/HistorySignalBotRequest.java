package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取历史信号机器人请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class HistorySignalBotRequest {
    /**
     * 策略订单类型
     */
    private String algoOrdType;
    
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 请求数据的时间范围，单位为毫秒
     */
    private String after;
    
    /**
     * 请求数据的时间范围，单位为毫秒
     */
    private String before;
    
    /**
     * 返回结果的数量，最大为100，默认返回100条
     */
    private String limit;
}