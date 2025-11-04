package com.ray.crypto.module;

import lombok.Data;

/**
 * 撤销策略委托订单响应
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelAlgoOrderInfo {
    /**
     * 策略委托订单ID
     */
    private String algoId;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 系统完成订单请求处理的时间戳
     */
    private String ts;
    
    /**
     * 事件执行结果的code，0代表成功
     */
    private String sCode;
    
    /**
     * 事件执行失败或成功时的msg
     */
    private String sMsg;
}