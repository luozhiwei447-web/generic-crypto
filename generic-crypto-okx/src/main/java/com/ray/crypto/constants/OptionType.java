package com.ray.crypto.constants;

/**
 * 期权类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum OptionType {
    
    /** 看涨期权 */
    CALL("C"),
    
    /** 看跌期权 */
    PUT("P");
    
    private final String value;
    
    OptionType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}