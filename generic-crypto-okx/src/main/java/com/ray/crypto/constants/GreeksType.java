package com.ray.crypto.constants;

/**
 * Greeks展示类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum GreeksType {
    
    /** 币本位 */
    PA("PA"),
    
    /** 美元本位 */
    BS("BS");
    
    private final String value;
    
    GreeksType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}