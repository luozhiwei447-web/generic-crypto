package com.ray.crypto.module;

import lombok.Data;

/**
 * 大宗撤单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MassCancelOrderRequest {
    /**
     * 产品类型
     */
    private String instType;
    
    /**
     * 交易品种
     */
    private String instFamily;
    
    /**
     * 产品ID
     */
    private String instId;
}