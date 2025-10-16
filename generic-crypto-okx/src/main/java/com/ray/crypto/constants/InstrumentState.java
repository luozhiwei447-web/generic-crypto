package com.ray.crypto.constants;

/**
 * 产品状态枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum InstrumentState {
    
    /** 交易中 */
    LIVE("live"),
    
    /** 暂停中 */
    SUSPEND("suspend"),
    
    /** 预上线 */
    PREOPEN("preopen"),
    
    /** 测试中 */
    TEST("test");
    
    private final String value;
    
    InstrumentState(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}