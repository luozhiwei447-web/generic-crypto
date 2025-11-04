package com.ray.crypto.module;

import lombok.Data;

/**
 * 停止网格策略委托订单响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class StopGridAlgoOrderInfo {
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
}