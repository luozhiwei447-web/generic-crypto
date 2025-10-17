package com.ray.crypto.constants;

/**
 * 保证金调整类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum MarginAdjustType {
    
    /** 增加 */
    ADD("add"),
    
    /** 减少 */
    REDUCE("reduce");
    
    private final String value;
    
    MarginAdjustType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}