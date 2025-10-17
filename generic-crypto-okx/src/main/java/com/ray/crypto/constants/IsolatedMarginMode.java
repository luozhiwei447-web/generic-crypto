package com.ray.crypto.constants;

/**
 * 逐仓保证金模式枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum IsolatedMarginMode {
    
    /** 自动借币 */
    AUTOMATIC("automatic"),
    
    /** 自主借币 */
    AUTONOMY("autonomy");
    
    private final String value;
    
    IsolatedMarginMode(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}