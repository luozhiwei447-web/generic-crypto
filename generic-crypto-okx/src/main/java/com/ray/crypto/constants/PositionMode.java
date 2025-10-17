package com.ray.crypto.constants;

/**
 * 持仓模式枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum PositionMode {
    
    /** 单向持仓 */
    NET_MODE("net_mode"),
    
    /** 双向持仓 */
    LONG_SHORT_MODE("long_short_mode");
    
    private final String value;
    
    PositionMode(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}