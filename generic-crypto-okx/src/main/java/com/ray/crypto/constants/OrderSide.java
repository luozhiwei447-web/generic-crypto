package com.ray.crypto.constants;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 订单方向枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum OrderSide {
    
    /** 买入 */
    BUY("buy"),
    
    /** 卖出 */
    SELL("sell");
    
    private final String value;
    
    OrderSide(String value) {
        this.value = value;
    }
    
    @JsonValue
    public String getValue() {
        return value;
    }
}