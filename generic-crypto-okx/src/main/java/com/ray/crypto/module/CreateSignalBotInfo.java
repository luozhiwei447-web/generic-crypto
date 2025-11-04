package com.ray.crypto.module;

import lombok.Data;

/**
 * 创建信号机器人响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CreateSignalBotInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 客户自定义订单ID
     */
    private String algoClOrdId;
    
    /**
     * 事件执行结果的code，0代表成功
     */
    private String sCode;
    
    /**
     * 事件执行失败时的msg
     */
    private String sMsg;
    
    /**
     * 订单标签
     */
    private String tag;
}