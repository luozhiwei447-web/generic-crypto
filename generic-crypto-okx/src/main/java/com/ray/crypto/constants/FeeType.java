package com.ray.crypto.constants;

/**
 * 手续费抵扣类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum FeeType {
    
    /** USDT抵扣 */
    USDT("0"),
    
    /** OKB抵扣 */
    OKB("1"),
    
    /** 币种抵扣 */
    CURRENCY("2");
    
    private final String value;
    
    FeeType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}