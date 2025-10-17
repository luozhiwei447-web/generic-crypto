package com.ray.crypto.constants;

/**
 * 持仓方向枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum PositionSide {
    
    /** 多头 */
    LONG("long"),
    
    /** 空头 */
    SHORT("short"),
    
    /** 净持仓 */
    NET("net");
    
    private final String value;
    
    PositionSide(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}