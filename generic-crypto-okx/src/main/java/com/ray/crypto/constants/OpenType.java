package com.ray.crypto.constants;

/**
 * 开盘类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum OpenType {
    
    /** 定价开盘 */
    FIX_PRICE("fix_price"),
    
    /** 提前挂单 */
    PRE_QUOTE("pre_quote"),
    
    /** 集合竞价 */
    CALL_AUCTION("call_auction");
    
    private final String value;
    
    OpenType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}