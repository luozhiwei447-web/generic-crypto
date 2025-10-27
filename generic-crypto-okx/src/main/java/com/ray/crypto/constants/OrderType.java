package com.ray.crypto.constants;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 订单类型枚举
 * 
 * @author ray
 * @date 2024-01-01
 */
public enum OrderType {
    
    /** 市价单 */
    MARKET("market"),
    
    /** 限价单 */
    LIMIT("limit"),
    
    /** 只做maker单 */
    POST_ONLY("post_only"),
    
    /** 全部成交或立即取消 */
    FOK("fok"),
    
    /** 立即成交并取消剩余 */
    IOC("ioc"),
    
    /** 最优5档即时成交剩余撤销 */
    OPTIMAL_LIMIT_IOC("optimal_limit_ioc");
    
    private final String value;
    
    OrderType(String value) {
        this.value = value;
    }
    
    @JsonValue
    public String getValue() {
        return value;
    }
}