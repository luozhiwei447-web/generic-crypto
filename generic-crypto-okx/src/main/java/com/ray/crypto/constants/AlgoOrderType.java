package com.ray.crypto.constants;

/**
 * 策略委托订单类型
 *
 * @author ray
 * @date 2024-01-01
 */
public class AlgoOrderType {
    
    /**
     * 条件委托
     */
    public static final String CONDITIONAL = "conditional";
    
    /**
     * OCO委托
     */
    public static final String OCO = "oco";
    
    /**
     * 计划委托
     */
    public static final String TRIGGER = "trigger";
    
    /**
     * 移动止盈止损
     */
    public static final String MOVE_ORDER_STOP = "move_order_stop";
    
    /**
     * 时间加权委托
     */
    public static final String TWAP = "twap";
    
    /**
     * 冰山委托
     */
    public static final String ICEBERG = "iceberg";
}