package com.ray.crypto.module;

import lombok.Data;

/**
 * 撤销信号机器人子订单响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelSignalBotSubOrderInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 订单ID
     */
    private String ordId;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 事件执行结果的code，0代表成功
     */
    private String sCode;
    
    /**
     * 事件执行失败时的msg
     */
    private String sMsg;
}