package com.ray.crypto.constants;

/**
 * 策略委托订单状态
 *
 * @author ray
 * @date 2024-01-01
 */
public class AlgoOrderState {
    
    /**
     * 等待生效
     */
    public static final String LIVE = "live";
    
    /**
     * 暂停生效
     */
    public static final String PAUSE = "pause";
    
    /**
     * 部分生效
     */
    public static final String PARTIALLY_EFFECTIVE = "partially_effective";
    
    /**
     * 生效失败
     */
    public static final String EFFECTIVE_FAILURE = "effective_failure";
    
    /**
     * 已撤销
     */
    public static final String CANCELED = "canceled";
    
    /**
     * 订单完成
     */
    public static final String ORDER_COMPLETED = "order_completed";
}