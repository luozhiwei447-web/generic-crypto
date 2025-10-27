package com.ray.crypto.constants;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 交易模式枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum TradeMode {
    
    /** 现金 */
    CASH("cash"),
    
    /** 逐仓 */
    ISOLATED("isolated"),
    
    /** 全仓 */
    CROSS("cross");
    
    private final String value;
    
    TradeMode(String value) {
        this.value = value;
    }
    
    @JsonValue
    public String getValue() {
        return value;
    }
}