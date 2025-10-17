package com.ray.crypto.constants;

/**
 * 借币产品类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum BorrowType {
    
    /** 币币杠杆 */
    MARGIN("MARGIN"),
    
    /** 尊享借币 */
    VIP("VIP");
    
    private final String value;
    
    BorrowType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}