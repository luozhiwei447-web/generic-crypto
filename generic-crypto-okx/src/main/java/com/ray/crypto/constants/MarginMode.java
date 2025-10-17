package com.ray.crypto.constants;

/**
 * 保证金模式枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum MarginMode {
    
    /** 逐仓 */
    ISOLATED("isolated"),
    
    /** 全仓 */
    CROSS("cross");
    
    private final String value;
    
    MarginMode(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}