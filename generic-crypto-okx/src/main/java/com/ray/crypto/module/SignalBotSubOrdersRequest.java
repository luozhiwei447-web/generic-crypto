package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取信号机器人子订单信息请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SignalBotSubOrdersRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 订单类型
     */
    private String type;
    
    /**
     * 分组ID
     */
    private String groupId;
    
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