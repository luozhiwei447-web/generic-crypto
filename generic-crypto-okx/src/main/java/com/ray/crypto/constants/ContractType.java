package com.ray.crypto.constants;

/**
 * 合约类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum ContractType {
    
    /** 正向合约 */
    LINEAR("linear"),
    
    /** 反向合约 */
    INVERSE("inverse");
    
    private final String value;
    
    ContractType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}