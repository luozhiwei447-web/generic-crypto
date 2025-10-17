package com.ray.crypto.constants;

/**
 * 借币还币方向枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum BorrowRepaySide {
    
    /** 借币 */
    BORROW("borrow"),
    
    /** 还币 */
    REPAY("repay");
    
    private final String value;
    
    BorrowRepaySide(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}