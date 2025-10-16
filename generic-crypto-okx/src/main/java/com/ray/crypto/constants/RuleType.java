package com.ray.crypto.constants;

/**
 * 交易规则类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum RuleType {
    
    /** 普通交易 */
    NORMAL("normal"),
    
    /** 盘前交易 */
    PRE_MARKET("pre_market");
    
    private final String value;
    
    RuleType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}